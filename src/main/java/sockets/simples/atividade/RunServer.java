package sockets.simples.atividade;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RunServer {

	public static void main(String[] args) throws IOException {
		Map<String, String> ips = new HashMap<String, String>();
		
		String[] frases  = {
				"1 - N�o tinha medo o tal Jo�o de Santo Cristo",
				"2 - Era o que todos diziam quando ele se perdeu",
				"3 - Deixou pra tr�s todo o marasmo da fazenda",
				"4 - S� pra sentir no seu sangue o �dio que Jesus lhe deu",
				"5 - Quando crian�a s� pensava em ser bandido",
				"6 - Ainda mais quando com um tiro de soldado o pai morreu",
				"7 - Era o terror da cercania onde morava",
				"8 - E na escola at� o professor com ele aprendeu",
				"9 - Ia pra igreja s� pra roubar o dinheiro",
				"10 - Que as velhinhas colocavam na caixinha do altar",
				"11 - Sentia mesmo que era mesmo diferente",
				"12 - Sentia que aquilo ali n�o era o seu lugar",
				"13 - Ele queria sair para ver o mar",
				"14 - E as coisas que ele via na televis�o",
				"15 - Juntou dinheiro para poder viajar",
				"16 - De escolha pr�pria, escolheu a solid�o",
		};
		
		ServerSocket serverSocket = new ServerSocket(7030);
		int i = 0;
		while (true) {
			Socket conexao = serverSocket.accept();
			String hostAddress = conexao.getInetAddress().getHostAddress();
			if (ips.containsKey(hostAddress)) {
				new Thread(new EnviaMensagem(ips.get(hostAddress), conexao)).start();
			} else {
				String frase = frases[i++];
				ips.put(hostAddress, frase);
				new Thread(new EnviaMensagem(frase, conexao)).start();
			}
		}
	}

}
