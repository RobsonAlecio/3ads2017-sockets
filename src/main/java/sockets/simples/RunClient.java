package sockets.simples;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class RunClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 7070);
		
		OutputStream saida = socket.getOutputStream();
		saida.write("Requisão Legal\n".getBytes());
		
		InputStream entrada = socket.getInputStream();
		byte[] buffer = new byte[1];
		String resposta = "";
		
		do {
			entrada.read(buffer);
			
			resposta += new String(buffer);
		} while (buffer[0] != '\n');
		
		System.out.println(resposta);

	}

}
