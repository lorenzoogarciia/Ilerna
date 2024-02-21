package vt_01;

import Excepciones.ArchivoNoEncontradoException;
import Excepciones.ManejoArchivos;

public class EjExecepcionesNoEncontradoMain {

	public static void main(String[] args) {
		
		ManejoArchivos lectura = new ManejoArchivos();
		
		try {
		lectura.leerArchivo("hola");
		}catch (ArchivoNoEncontradoException e) {
			e.printStackTrace();
		}
		
		System.out.println("FIN DEL PROGRAMA");
	}

}
