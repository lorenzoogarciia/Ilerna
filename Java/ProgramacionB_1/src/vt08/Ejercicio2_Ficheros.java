package vt08;
import java.io.File;
import java.io.IOException;

public class Ejercicio2_Ficheros {

	public static void main(String[] args) {
		//Definir la ruta del directorio y del fichero de texto
		File miDirectorio = new File("C:\\PruebaIO");
		File miArchivo = new File("C:\\PruebaIO\\miFichero.txt");
		
		try {
			miDirectorio.mkdir();
			if(miArchivo.createNewFile())
				System.out.println("Fichero creado correctamente...");
			else 
				System.out.println("ERROR: No se ha podido crear el fichero");
		}catch (IOException e){
			e.printStackTrace();
		}
		System.out.println("Fin del programa...");
	}

}
