package hilos;

public class EjemploHilos extends Thread {
	public void run() {
		//Mostramos la informacion por pantalla
		System.out.println("DENTRO DEL HILO: " + Thread.currentThread().getName() +
				"\n\tPrioridad: " + Thread.currentThread().getPriority() +
				"\n\tID: " + Thread.currentThread().getId() + 
				"\n\tHilos activos: " + Thread.currentThread().activeCount());
	}
}
