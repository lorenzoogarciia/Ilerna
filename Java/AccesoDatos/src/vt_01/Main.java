package vt_01;

import java.io.*;

public class Main {

	public static void main(String[] args) {
		// Definir la ruta del directorio y del fichero de texto
		File miDirectorio = new File("src/miDirectorio");
		File miFichero = new File("src/miDirectorio/miFichero.txt");
		File dirAbsoluto = new File("C:\\DirectorioAbsoluto");
		File ficheroAbsoluto = new File("C:\\DirectorioAbsoluto\\ficheroAbsoluto.txt");
		
		try {
			dirAbsoluto.mkdir();
			if(ficheroAbsoluto.createNewFile()) {
				System.out.println("Fichero creado correctamente...");

			}else System.out.println("ERROR: No se ha podido crear el fichero."); 
		}catch (IOException e) {
				e.printStackTrace();
			}
		System.out.println("FIN DEL PROGRAMA");

	}

}
