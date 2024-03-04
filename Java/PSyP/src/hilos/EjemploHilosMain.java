package hilos;

public class EjemploHilosMain extends Thread{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread.currentThread().setName("Principal");
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().toString());
		
		EjemploHilos h = null;
		for(int i=0;i<3;i++) {
			h = new EjemploHilos();
			h.setName("Hilo " + i);
			h.setPriority(i+1);
			
			if(h.getPriority()==3) {
				System.out.println("Se ha interrumpido la ejecucion del hilo " + h.getName());
				h.interrupt();
			}else {
				h.start();
			}
		}
		System.out.println("3 hilos creados...");
		System.out.println("Hilos activos: " + Thread.activeCount());
	}

}
