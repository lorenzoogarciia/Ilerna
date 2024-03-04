package hilos;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			try {
				for(int i = 0; i<5;i++) {
					Saludo s = new Saludo(i);
					s.start();
					s.join();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("---- FIN DE LA EJECUCION DEL PROGRAMA ----");
		}
}

