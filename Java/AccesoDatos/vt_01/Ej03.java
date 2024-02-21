package vt_01;
import java.io.*;
import java.util.Scanner;
public class Ej03 {

	public static void main(String[] args) {
		
		int opcion;
		Scanner sc = new Scanner(System.in);
		
		File miDirectorioInicio = new File("C:\\AD\\Ejercicios");
		File miDirectorio = new File("C:\\AD\\Ejercicios\\nuevoDirectorio");
		File miFichero = new File("C:\\AD\\Ejercicios\\Fichero_de_texto.txt");
		File miFichero2 = new File("C:\\AD\\Ejercicios\\nuevoDirectorio\\MiFichero2.txt");
		
		try {
			miDirectorioInicio.mkdir();
			if(miFichero.createNewFile()) {
				System.out.println("Fichero creado correctamente.");
			}
		}catch (IOException e) {
			e.printStackTrace();
		}

		do {
			System.out.println("----------   CREAR UN FICHERO DE TEXTO    ----------");
			System.out.println("                  MENÚ DE OPCIONES                  ");
			System.out.println(" 1. Crear directorio nuevoDirectorio ");
			System.out.println(" 2. Crear fichero mifichero2.txt en nuevoDirectorio ");
			System.out.println(" 3. Eliminar fichero miFichero.txt ");
			System.out.println(" 4. Eliminar directorio nuevoDirectorio ");
			System.out.println(" 0. Salir");
			System.out.print("   Elige una opción: ");
			opcion = sc.nextInt();
			
			switch(opcion) {
			
			case 1: //Crear directorio nuevoDirectorio
				if(miDirectorio.mkdir()) {
					System.out.println("Directorio creado correctamente.");
				}else {
					System.out.println("ERROR: El directorio no ha podido ser creado.");
				}break;
			
			case 2: //Crear fichero miFichero2.txt en nuevoDirectorio
				try {
					if(miFichero2.createNewFile()) {
						System.out.println("Fichero creado correctamente.");
					}else {
						System.out.println("ERROR: El fichero no ha podido ser creado.");
					}
				}catch (IOException e) {
					e.printStackTrace();
				}break;
				
			case 3: //Eliminar el fichero miFichero2.txt
				if(miFichero2.delete()) {
					System.out.println("Fichero borrado correctamente.");
				}else {
					System.out.println("ERROR: El fichero no ha podido ser borrado");
					
				}break;
				
			case 4: //Eliminar el directorio nuevoDirectorio
				miDirectorio.delete();
				System.out.println("Directorio borrado correctamente.");
				break;
			
			case 0: //Salir
				System.out.println("Gracias por usar este programa.");
				break;
			
			default: //Opcion incorrecta
				System.out.println("Opción inválida, vuelva a escoger.");
			}
			
		}while (opcion != 0);
		
		System.out.println("----   FIN DEL PROGRAMA   ----");
	}

}
