package vt06;
import java.util.*;

public class Ejercicio26_HashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet <String> hash = new HashSet<>();
		
		//Insertamos elementos en el hashset
		hash.add("Lorenzo");
		hash.add("Valme");
		hash.add("Paula");
		
		System.out.println("HashSet= " + hash);
		
		boolean b = hash.add("Artur");
		
		if(b) {
			System.out.println("Elemento añadido al HashSet");
		}else {
			System.out.println("ERROR: El elemento ya existe en el HashSet");
		}
		System.out.println("HashSet= " + hash);
		//Se mostraría por pantalla la coleccion hash
		//Eliminar un elemento del HashSet
		boolean b2 = hash.remove("JC");
		if(b2) {
			System.out.println("Elemento removido correctamente del HashSet.");
		}else {
			System.out.println("ERROR: El elemento no existía en el HashSet.");
		}
		System.out.println("HashSet= " + hash);
	}

}
