package server;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.net.*;
import java.util.Scanner;

public class Server {
	private final int puerto = 9876;
	private ServerSocket serverSocket;
	private Socket socket;
	
	public Server() throws IOException{
		serverSocket = new ServerSocket(puerto);
		socket = new Socket();
	}	
	
	public void iniciarServer() throws IOException{
		
			try {
				
				
	            // Esperar a que un cliente se conecte
	            Socket clientSocket = serverSocket.accept();
	            System.out.println("Cliente conectado desde " + clientSocket.getInetAddress());

	            // Establecer flujos de entrada/salida con el cliente
	            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
	            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());

	            // Pedir el nombre al cliente y recibirlo
	            out.writeObject("Bienvenido/a,¿Como te llamas?: ");
	            String nombreCliente = (String) in.readObject();
	            System.out.println("Mensaje enviado al servidor: " + nombreCliente);

	            // Pedir el número de tareas al cliente y recibirlo
	            out.writeObject("Ingrese el número de tareas a realizar:");
	            int numTareas = (int) in.readObject();
	            System.out.println("Número de tareas a realizar: " + numTareas);
	            
	            List<Tarea> tareas = new ArrayList<>();
	            
	            // Bucle para procesar cada tarea
	            for (int i = 1; i <= numTareas; i++) {
	               out.writeObject("Tarea: " + i);
	               out.writeObject("Descripcion de la tarea: ");
	               String descripcion = (String) in.readObject();
	               
	               out.writeObject("Estado de la tarea:");
	               String estado = (String) in.readObject();
	               
	               Tarea tarea = new Tarea(descripcion, estado);
	               tareas.add(tarea);
	            }

	            // Enviar todas las tareas al cliente (puedes implementar una clase Tarea para una estructura más organizada)
	            out.writeObject(tareas);
	            
	            clientSocket.close();
	            serverSocket.close();
			
			}catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			
	}

}

