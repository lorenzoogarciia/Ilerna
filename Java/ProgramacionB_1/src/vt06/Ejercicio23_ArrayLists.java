package vt06;
import java.util.*;

/*Listas:
 * - Secuencia de elementos que ocupan una posici�n determinada
 * - Elementos pueden estar repetidos
 * - Elementos se indexan mediante un �ndice num�rico*/

/*ArrayList:
 * - Implementa una lista de elementos mediante un array de tama�o variable
 * - M�todos m�s importantes:
 * 	- get(int):
 * 		- Obtener el objeto de la posici�n indicada como argumento de entrada
 * 	- indexOf(object):
 * 		- Obtener la posici�n del objeto indicado
 * 	- isEmpty():
 * 		- Booleano para comprobar si existen datos
 * 	- add(Object): 
 * 		- Insertar Object en la �ltima posici�n
 * 	- add(int, Object):
 * 		- Insertar Object en la posici�n indicada
 * 	- set(int, Object):
 * 		- Insertar Object en la posici�n indicada, reemplaza el anterior valor
 * 	- toArray():
 * 		- Convierte el ArrayList en un array del tipo especificado*/
public class Ejercicio23_ArrayLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Instancia de tipo Gen�rico (cuando no sabemos que tipo de datos
		//vamos a introducir en la colecci�n)
		/*C�digo de ejemplo:
		 * 	ArrayList nombre = new ArrayList();*/
		
		//Instancia de colecci�n de tipo espec�fico
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
			System.out.println(numeros.get(i)); //Para comprobar que se han insertado correctamente los n�meros
		}
		
		//�D�nde lo insertar�?
		numeros.add(7);
		for (int i=0;i<numeros.size();i++) {
			System.out.println(numeros.get(i)); 
		System.out.println("------------------------");
		}
		
		/*
		 * �Qu� pasa si le queremos a�adir un elemento en una posici�n superior al tama�o de la lista?
		 */
		System.out.println("Tama�o de la lista: " + numeros.size());
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
