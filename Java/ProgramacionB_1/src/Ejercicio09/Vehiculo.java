package Ejercicio09;

public abstract class Vehiculo {
	//colores de los que se pueden pintar un vehiculo
	public static enum Color{ROJO, VERDE, AZUL}
	//atributos
	protected static String color;
	protected final int numSerie;
	
	public Vehiculo() {
		Vehiculo.color="";
		this.numSerie=0;
	}
	
	public Vehiculo(String color, int numSerie) {
		this.numSerie=numSerie;
	}
	
	public String color() {
		return color;
	}
	
	public int getNumSerie() {
		return numSerie;
	}
	
	public void pintarVehiculo(String c) {
		color = c;
	}
	
	public abstract void arrancar();
}
