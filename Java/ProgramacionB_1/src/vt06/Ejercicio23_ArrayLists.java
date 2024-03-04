package vt06;
import java.util.*;

/*Listas:
 * - Secuencia de elementos que ocupan una posición determinada
 * - Elementos pueden estar repetidos
 * - Elementos se indexan mediante un índice numérico*/

/*ArrayList:
 * - Implementa una lista de elementos mediante un array de tamaño variable
 * - Métodos más importantes:
 * 	- get(int):
 * 		- Obtener el objeto de la posición indicada como argumento de entrada
 * 	- indexOf(object):
 * 		- Obtener la posición del objeto indicado
 * 	- isEmpty():
 * 		- Booleano para comprobar si existen datos
 * 	- add(Object): 
 * 		- Insertar Object en la última posición
 * 	- add(int, Object):
 * 		- Insertar Object en la posición indicada
 * 	- set(int, Object):
 * 		- Insertar Object en la posición indicada, reemplaza el anterior valor
 * 	- toArray():
 * 		- Convierte el ArrayList en un array del tipo especificado*/
public class Ejercicio23_ArrayLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Instancia de tipo Genérico (cuando no sabemos que tipo de datos
		//vamos a introducir en la colección)
		/*Código de ejemplo:
		 * 	ArrayList nombre = new ArrayList();*/
		
		//Instancia de colección de tipo específico
		/*
		 ArrayList <tipo_de_Dato> nombre = new ArrayList<>();
		 */
		
		ArrayList<Integer> numeros = new ArrayList<>();
		
		//Insertamos valores
		numeros.add(4);
		numeros.add(5);
		numeros.add(6);
		numeros.add(7);
		
		//Insertamos indicando la posicion
		numeros.add(0,1);
		numeros.add(1,2);
		
		for (int i=0;i<numeros.size();i++) {
			System.out.println(numeros.get(i)); //Para comprobar que se han insertado correctamente los números
		}
		
		//¿Dónde lo insertará?
		numeros.add(7);
		for (int i=0;i<numeros.size();i++) {
			System.out.println(numeros.get(i)); 
		System.out.println("------------------------");
		}
		
		/*
		 * ¿Qué pasa si le queremos añadir un elemento en una posición superior al tamaño de la lista?
		 */
		System.out.println("Tamaño de la lista: " + numeros.size());
		//numeros.add(9,9);
		//Da error, obviamente
		
		numeros.set(2,10);
		for (int i=0;i<numeros.size();i++) {
			System.out.println(numeros.get(i));
			numeros.remove(2);
			for (int j=0;j<numeros.size();j++) {
				System.out.println(numeros.get(1));
			}
		}
	}

}
