package Aburrimiento;
import javax.swing.*;
public class ASCII {

	public static void main(String[] args) {
		// Programa que transforma un número a su valor en la tabla ASCII
				String texto=JOptionPane.showInputDialog("Introduce un codigo de la tabla ASCII");
				//Pasamos el String a int
				int codigo=Integer.parseInt(texto);

				//Pasamos el codigo a caracter
				char caracter=(char)codigo;

				System.out.println(caracter);
			}
		

}
