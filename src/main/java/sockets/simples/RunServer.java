package sockets.simples;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class RunServer {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(7070);

		Socket conexao = serverSocket.accept();
		InputStream entrada = conexao.getInputStream();
		
		byte[] buffer = new byte[1];
		String requisicao = "";
		
		do {
			entrada.read(buffer);
			
			requisicao += new String(buffer);
		} while (buffer[0] != '\n');
		
		System.out.println(requisicao);
		
		OutputStream saida = conexao.getOutputStream();
		saida.write("Retorno nada haver\n".getBytes());
	}
}
