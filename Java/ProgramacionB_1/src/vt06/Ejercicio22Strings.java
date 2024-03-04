/*Escribe un programa que pida una cadena de texto al usuario y a continuaci�n
 * pida al usuario un car�cter cualquiera. A continuaci�n, el programa
 * determinar� el n�mero de aparaciones que tiene dicho car�cter en la cadena introducida*/

package vt06;

import java.util.Scanner;

public class Ejercicio22Strings {
	
	public static String charToString(char car) {
		return String.valueOf(car);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String frase;
		char car = '0';
		String aux = charToString(car);
		Scanner sc = new Scanner(System.in);
		int contador = 0;
		
		
		System.out.println("Introduce una frase: ");
		frase = sc.nextLine();
		System.out.println("Introduce un car�cter cualquiera: ");
		aux = sc.nextLine();
		car = aux.charAt(0);

		for(int i=0;i<frase.length();i++) {
			if(frase.charAt(i) == car ) {
				contador++;
			}
		}
		
		System.out.println("La cadena contiene " + contador + " veces el caracter introducido");
	}

}
