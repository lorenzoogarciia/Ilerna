package Excepciones;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ManejoArchivos {
	public void leerArchivo (String nombreArchivo) throws ArchivoNoEncontradoException {
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(nombreArchivo));
			String linea;
			while((linea = reader.readLine())!= null) {
				System.out.println(linea);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			throw new ArchivoNoEncontradoException("El archivo " + nombreArchivo + " no se ha encontrado.");
		}catch(IOException e) {
			System.out.println("Ha ocurrido un error al leer el archivo");
		}
	}
}
