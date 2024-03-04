package hilos;

public class MainAtleta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Atleta[] atletas = new Atleta[10];
		
		for(int i = 0;i<10;i++) {
			atletas[i] = new Atleta("Atleta " + (i+1));
			atletas[i].start();
		}
		for(Thread hilo:atletas) {
			try {
				hilo.join();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("--- LA CARRERA HA FINALIZADO ---");
	}
	
}
