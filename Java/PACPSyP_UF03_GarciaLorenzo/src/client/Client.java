package client;

import java.io.IOException;
import java.util.List;
import java.net.*;
import java.io.*;
import server.Tarea;

public class Client {
	private final String host = "localhost";
	private final int port = 9876;
	private Socket socket;
	
	public Client() throws IOException{
		socket = new Socket(host,port);
	}
	
	public void iniciarCliente() throws IOException{
		try {
			
            // Establecer flujos de entrada/salida con el servidor
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

            // Recibir el mensaje de bienvenida del servidor
            String mensajeBienvenida = (String) in.readObject();
            System.out.println(mensajeBienvenida);

            // Enviar el nombre al servidor
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String nombreCliente = reader.readLine();
            out.writeObject(nombreCliente);

            // Recibir el mensaje para ingresar el número de tareas
            String mensajeNumTareas = (String) in.readObject();
            System.out.print(mensajeNumTareas);
            int numTareas = Integer.parseInt(reader.readLine());
            out.writeObject(numTareas);
            
           Object objetoRecibido = in.readObject();
           
           if(objetoRecibido instanceof List) {
        	   List<Tarea> tareas = (List<Tarea>) objetoRecibido;
               
               // Bucle para enviar la descripción y el estado de cada tarea
               for (int i = 0; i <= tareas.size(); i++) {
               	Tarea tarea = tareas.get(i);
                   System.out.println("Tarea: " + (i + 1));
                   System.out.println("Descripción: " + tarea.getDescripcion());
                   System.out.println("Estado: " + tarea.getEstado());
                   System.out.println();
               }
           }else if(objetoRecibido instanceof String) {
        	   System.out.println((String) objetoRecibido);
           }else {
        	   System.out.println("Objeto no reconocido: " + objetoRecibido.toString());
           }

            // Cerrar la conexión
            socket.close();
			
		}catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		}

}

