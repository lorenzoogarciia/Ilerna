/*Escribe un programa que pida una cadena de texto
 * al usuario e indique cuantas vocales tiene*/

package vt06;
import java.util.Scanner;


public class Ejercicio20Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String frase;
		Scanner sc = new Scanner(System.in);
		int contador = 0;
		
		System.out.println("Introduce una frase: ");
		frase = sc.nextLine();
		
		for(int i=0;i<frase.length();i++) {
			if ((frase.charAt(i)=='a') || (frase.charAt(i)== 'e') || (frase.charAt(i)=='i')
				|| (frase.charAt(i)=='o') || (frase.charAt(i)=='u')) {
				contador++;
			}
		}
		System.out.println("La frase tiene " + contador + " vocales");
	}

}
