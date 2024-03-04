package vt07;
import java.util.Scanner;
import java.util.regex.Pattern;
public class ExpresionesRegulares {

	public static boolean comprobarDNI(String dni) {
		String validar = "^[0-9]{8}-?[A-Z]{1}$";
		Pattern patron = Pattern.compile(validar);
		return patron.matcher(dni).matches();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String dni;
		System.out.println("Introduzca DNI: ");
		dni = sc.nextLine();
		if(comprobarDNI(dni)==true) {
			System.out.println("DNI Validado");
		}else {
			
			System.out.println("DNI no Válido");
		}
		
		
	}

}
