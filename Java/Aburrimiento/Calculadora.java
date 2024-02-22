package Java.Aburrimiento;
import java.util.Scanner;
public class Calculadora {
	
	public static void crearMenu() {
		System.out.println("\nIntroduce una acci�n");
		System.out.println("1 Sumar");
		System.out.println("2 Restar");
		System.out.println("3 Multiplicar");
		System.out.println("4 Dividir");
		System.out.println("5 Resto");
		System.out.println("0 Salir");
	}
	
	public static double pedirNum1(double num1) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce el primer n�mero: ");
		num1 = sc.nextDouble();
		return num1;
	}
	public static double pedirNum2(double num2) {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nIntroduce el segundo n�mero: ");
		num2=sc.nextDouble();
		return num2;
	}
	
	public static double sumarNum(double num1,double num2) {
		double suma;
		suma = num1 + num2;
		return suma;
	}
	
	public static double restarNum(double num1,double num2) {
		double resta;
		resta = num1 - num2;
		return resta;
	}
	
	public static double multiNum(double num1,double num2) {
		double multi;
		multi = num1 * num2;
		return multi;
	}
	
	public static double dividirNum(double num1,double num2) {
		double division;
		division = num1 / num2;
		return division;
	}
	
	public static double restoNum(double num1,double num2) {
		double resto;
		resto = num1 % num2;
		return resto;
	}
	
	public static void main(String[] args) {
			double num1=0,num2=0;
			Scanner sc = new Scanner(System.in);
			int option = 0;
			do{
				num1 = pedirNum1(num1);
				num2 = pedirNum2(num2);
				crearMenu();
				option=sc.nextInt();
				switch(option) {
				case 1:
					System.out.println(sumarNum(num1,num2));
					break;
				case 2:
					System.out.println(restarNum(num1,num2));
					break;
				case 3:
					System.out.println(multiNum(num1,num2));
					break;
				case 4:
					System.out.println(dividirNum(num1,num2));
					break;
				case 5:
					System.out.println(restoNum(num1,num2));
					break;
				case 0:
					System.out.println("Muchas gracias por utilizar el programa.");
					break;
				default:
					System.out.println("ERROR: Opci�n inv�lida. Vuelva a intentarlo");
				}
			}while(option!=0);
	}


}
