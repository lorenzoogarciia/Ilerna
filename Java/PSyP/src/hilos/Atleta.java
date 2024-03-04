package hilos;

import java.util.Random;

public class Atleta extends Thread {
	private String nombre;
	private int distanciaRecorrida;
	
	public Atleta(String nombre) {
		this.nombre = nombre;
		this.distanciaRecorrida = 0;
	}
	
	public void run() {
		Random random = new Random();
		int distanciaMeta = 100;
		
		while(distanciaRecorrida<distanciaMeta) {
			int metrosAvanzados = random.nextInt(11);
			distanciaRecorrida += metrosAvanzados;
			
			if(distanciaRecorrida >= distanciaMeta) {
				distanciaRecorrida = distanciaMeta;
			}
			System.out.println(nombre + " Ha recorrido: " + distanciaRecorrida + " metros");
		}
		
		System.out.println(nombre + " ha cruzado la linea de meta");
	}
}
