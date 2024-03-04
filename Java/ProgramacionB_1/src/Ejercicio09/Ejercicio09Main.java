package Ejercicio09;

public class Ejercicio09Main {
	
	public static void main(String[] args) {
	Coche mercedes = new Coche("ROJO",0345, 143);
	Barco smt = new Barco("AZUL",2341);
	
	mercedes.cambiarCilindrada(205);
	System.out.println(mercedes.getCilindrada());
	System.out.println(smt.getNumSerie());
	mercedes.arrancar();
	smt.arrancar();
	}
}
