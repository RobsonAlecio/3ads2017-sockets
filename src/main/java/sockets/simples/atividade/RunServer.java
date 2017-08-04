package sockets.simples.atividade;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class RunServer {

	public static void main(String[] args) throws IOException {
		Set<String> ips = new HashSet<String>();
		
		String[] frases  = {
				"1 - Não tinha medo o tal João de Santo Cristo",
				"2 - Era o que todos diziam quando ele se perdeu",
				"3 - Deixou pra trás todo o marasmo da fazenda",
				"4 - Só pra sentir no seu sangue o ódio que Jesus lhe deu",
				"5 - Quando criança só pensava em ser bandido",
				"6 - Ainda mais quando com um tiro de soldado o pai morreu",
				"7 - Era o terror da cercania onde morava",
				"8 - E na escola até o professor com ele aprendeu",
				"9 - Ia pra igreja só pra roubar o dinheiro",
				"10 - Que as velhinhas colocavam na caixinha do altar",
				"11 - Sentia mesmo que era mesmo diferente",
				"12 - Sentia que aquilo ali não era o seu lugar",
				"13 - Ele queria sair para ver o mar",
				"14 - E as coisas que ele via na televisão",
				"15 - Juntou dinheiro para poder viajar",
				"16 - De escolha própria, escolheu a solidão",
		};
		
		ServerSocket serverSocket = new ServerSocket(7030);
		int i = 0;
		while (true) {
			Socket conexao = serverSocket.accept();
			if (ips.contains(conexao.getInetAddress().getHostAddress())) {
				new Thread(new EnviaMensagem("Espertinho, você já recebeu a sua frase. Sossega o rabicó.", conexao)).start();
			} else {
				ips.add(conexao.getInetAddress().getHostAddress());
				new Thread(new EnviaMensagem(frases[i++], conexao)).start();
			}
		}
	}

}
