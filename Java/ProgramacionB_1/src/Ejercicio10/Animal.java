package Ejercicio10;

public class Animal {
	//Definicion de metodos
	private String nombre;
	private int numPatas;
	
	//Constructores
	public Animal() {
		nombre="";
		numPatas=0;
	}
	
	public Animal(String nombre, int numPatas) {
		this.nombre=nombre;
		this.numPatas=numPatas;
	}
	
	//Métodos get y set
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre=nombre;}
	
	public int getNumPatas() {return numPatas;}
	public void setNumPatas(int numPatas) {this.numPatas=numPatas;}
	
	
}
