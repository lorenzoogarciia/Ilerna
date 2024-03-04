package hilos;

public class MainTicTac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tic tic = new Tic(1);
		Tac tac = new Tac(2);
		
		tic.start();
		tac.start();

	}

}
