package Ejercicio09;

public class Coche extends Vehiculo {
	
	private int cilindrada;
	
	public Coche(String color, int numSerie, int cilindrada) {
		super(color, numSerie);
		this.cilindrada=cilindrada;
	}
	
	public int getCilindrada() {return cilindrada;}
	
	public void cambiarCilindrada(int cilindrada) {
		this.cilindrada=cilindrada;
	}

	@Override
	public void arrancar() {
		// TODO Auto-generated method stub
		System.out.println("FLIPAMILOCO");
	}
	
}
