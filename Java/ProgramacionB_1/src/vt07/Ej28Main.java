package vt07;
import java.util.Scanner;
public class Ej28Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Creamos un objeto para leer lo que introducimos por teclado
		Scanner lectura = new Scanner(System.in);
		//Creamos un objeto de la clase persona
		Ej28Persona persona = new Ej28Persona();
		
		//Pedimos el nombre de la persona
		System.out.println("Introduzca el nombre de la persona: ");
		String nombreUsuario = lectura.nextLine();
		persona.setNombre(nombreUsuario);
		
		//Pedimos el email de la persona
		boolean emailValido = false;
		do {
			System.out.println("Introduce tu email: ");
			String validarEmail = lectura.nextLine();
			try {
				if(persona.setEmail(validarEmail)) 
					emailValido = true;
				
			}catch(Ejercicio28_EmailException e) {
				System.out.println(e.getMessage());
			}
		}while(!emailValido);
		
		System.out.println(persona.toString());
		System.out.println("Fin del programa");
		lectura.close();
		
		
		
	}

}
