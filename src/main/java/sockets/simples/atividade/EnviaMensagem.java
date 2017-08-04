package sockets.simples.atividade;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class EnviaMensagem implements Runnable {

	private String frase;
	private Socket conexao;

	public EnviaMensagem(String frase, Socket conexao) {
		this.frase = frase;
		this.conexao = conexao;
	}

	public void run() {
		InetAddress address = conexao.getInetAddress();
		System.out.printf("Enviando %s para %s - %s:%d.\n", frase, address.getHostName(), address.getHostAddress(), conexao.getPort());
		
		try {
			conexao.getOutputStream().write((frase + '\n').getBytes());
		} catch (IOException e) {
			System.out.printf("Falha ao enviar %s para %s - %s:%d.\n", frase, address.getHostName(), address.getHostAddress(), conexao.getPort());
			e.printStackTrace();
		}
	}

}
