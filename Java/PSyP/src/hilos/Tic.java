package hilos;


public class Tic extends Thread {
	private int hilo;
	
	public Tic(int hilo) {
		this.hilo = hilo;
	}
	
	public void run() {
		while(true) {
			try {
				System.out.println("Hilo: " + hilo + "dice: TIC");
				sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
