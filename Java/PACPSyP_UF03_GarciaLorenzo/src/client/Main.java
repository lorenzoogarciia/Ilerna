package client;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException{
		// Creamos el objeto cliente
		Client client = new Client();
		System.out.println("--- INICIANDO CLIENTE ---");
		
		//Iniciamos la conexion
		client.iniciarCliente();

	}

}
