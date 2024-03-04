package hilos;

public class Saludo extends Thread {
	int numHilo = 0;
	
	public Saludo(int numHilo) {
		this.numHilo=numHilo;
	}
	
	public void run() {
		System.out.println("---- ARRANCA EL HILO N�: " + numHilo);
		for(int i = 0;i<10;i++) {
			System.out.println("HILO N�: " + numHilo + " TE SALUDA (Vez: " + (i+1) + ")");
		}
		System.out.println("---- FIN DEL HILO N�: " + numHilo);
	}
}
