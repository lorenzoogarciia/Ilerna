package vt07;
import java.util.Scanner;

import ajedrezPOO.TableroAjedrez;


public class Menu {
	
	public static void crearTablero() {
		TableroAjedrez tablero = new TableroAjedrez();
		System.out.println("Vamos a mostrar el tablero: ");
		tablero.mostrarTablero();
	}
	

	public static void muestraMenu() {
		System.out.println("===Men�===");
		System.out.println("1. Crear objeto clase import�ndola de otro paquete");
		System.out.println("2. Crear objeto clase Perro import�ndola de otro proyecto");
		System.out.println("3. Exit");
		System.out.println("Introduce una opci�n: ");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
