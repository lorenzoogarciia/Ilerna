/*Escribe un programa que pida una cadena de texto al usuario y muestre por consola dicha cadena de forma invertida*/

package vt06;

import java.util.Scanner;

public class Ejercicio21Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String frase;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce una frase: ");
		frase = sc.nextLine();
		
		StringBuilder inversor = new StringBuilder(frase);
		
		inversor.reverse();
		
		System.out.println(inversor);
		
	}

}
