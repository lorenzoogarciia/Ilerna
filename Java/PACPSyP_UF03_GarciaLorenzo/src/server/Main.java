package server;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException{
		// Definimos el objeto servidor
		Server server = new Server();
		System.out.println("--- INICIANDO SERVIDOR ---");
		
		//Iniciamos el servidor
		server.iniciarServer();

	}

}
