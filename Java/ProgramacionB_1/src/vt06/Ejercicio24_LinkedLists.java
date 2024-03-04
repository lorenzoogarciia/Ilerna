package vt06;
import java.util.*;

public class Ejercicio24_LinkedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> linked = new LinkedList<>(); //Lista de enteros
		linked.add(2);
		linked.addLast(3);
		linked.addFirst(1);
		linked.add(3,4); //Indice 3, valor 4
		
		System.out.println("Mostramos la lista con FOR...");
		
		for (int i=0;i<linked.size();i++) {
			System.out.println(linked.get(i));
		}
		
		System.out.println("Mostramos la lista con ITERATOR...");
		Iterator<Integer> iteratorLK = linked.iterator();
		
		while (iteratorLK.hasNext()) {
			System.out.println(iteratorLK.next());
		}
		
	}

}
