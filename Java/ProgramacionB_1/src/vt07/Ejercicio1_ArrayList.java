package vt07;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.util.Random;

public class Ejercicio1_ArrayList {
	
	//Funcion que rellene un ArrayList de enteros
	public static void generarNumeros(ArrayList<Integer> listado, int n) {
		Random rand = new Random();
		
		for(int i=0;i<n;i++) {
			int num = rand.nextInt(1492, 5654);
			listado.add(num);
		}
	}
	
	public static void numMinMax(ArrayList<Integer> listado) {
		int min = Collections.min(listado);
		int max = Collections.max(listado);
		
		System.out.println("El número máximo del array es: " + max);
		System.out.println("El número mínimo del array es: " + min);

	}
	
	public static void arrayInversor(ArrayList<Integer> listado) {
		ListIterator<Integer> iterador = listado.listIterator(listado.size());
		while (iterador.hasPrevious()) {
			System.out.print(iterador.previous() + " ");
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arrayNumeros = new ArrayList<>();
		//Generar números del listado
		generarNumeros(arrayNumeros,10);
		//Imprimimos los valores del arrayList por pantalla 
		System.out.println("ArrayList de enteros:\n" + arrayNumeros);
		//Imprimimos el mínimo y el máximo por pantalla del ArrayList
		numMinMax(arrayNumeros);
		//Escribir el ArrayList de forma inversa
		System.out.println("Array invertido:");
		arrayInversor(arrayNumeros);
		
	}

}
