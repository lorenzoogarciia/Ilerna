import java.util.Scanner;
public class Main {

	public static void mostrarMenu() {
		System.out.println("\nRealiza una nueva acción");
		System.out.println("1 Introduce un nuevo gasto");
		System.out.println("2 Introduce un nuevo ingreso");
		System.out.println("3 Mostrar gastos");
		System.out.println("4 Mostrar ingresos");
		System.out.println("5 Mostrar saldo");
		System.out.println("0 Salir");
	}
	
	public static void crearCuenta(Usuario usuario1, Cuenta cuenta1) {
		Scanner sc = new Scanner(System.in);
		
        System.out.print("Introduce el nombre del usuario: ");
        usuario1.setNombre(sc.nextLine());

        System.out.print("Introduce la edad del usuario: ");
        usuario1.setEdad(sc.nextInt());
        boolean dniValido = false;
        while(!dniValido) {
        System.out.print("Introduce el DNI del usuario: ");
        dniValido = usuario1.setDNI(sc.nextLine());
        }
        System.out.println("Usuario creado: " + usuario1.toString());
        System.out.println("Cuenta creada para: " + usuario1.getNombre() + "\nSaldo: " + cuenta1.getSaldo() );
        
	}
	
	public static String pedirDescripcion(String description) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una descripción: ");
		description = sc.nextLine();
		return description;
	}
	
	public static double pedirCantidad(double cantidad) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una cantidad: ");
		cantidad = sc.nextDouble();
		return cantidad;
	}
	
	
	
	public static void main(String[] args) throws GastoException {
		// TODO Auto-generated method stub
		int option = 0;
		double cantidad = 0;
		String description = "";
		Scanner sc = new Scanner(System.in);
		Usuario usuario1 = new Usuario();
		Cuenta cuenta1 = new Cuenta(usuario1);
		crearCuenta(usuario1, cuenta1);
		do {
			mostrarMenu();
			System.out.println("Introduce una opción: ");
			option = sc.nextInt();
			switch(option) {
				case 1:
					System.out.println("Has elegido hacer un gasto: ");
					cantidad = pedirCantidad(cantidad);
					description = pedirDescripcion(description);
					cuenta1.addGastos(description, cantidad);
					System.out.println(cuenta1.toString());
					break;
				case 2:
					System.out.println("Has elegido ingresar dinero: ");
					cantidad = pedirCantidad(cantidad);
					description = pedirDescripcion(description);
					cuenta1.addIngresos(description, cantidad);
					System.out.println(cuenta1.toString());
					break;
				case 3:
					System.out.println("Gastos: " + cuenta1.getGastos());
					break;
				case 4:
					System.out.println("Ingresos: " + cuenta1.getIngresos());
					break;
				case 5: 
					System.out.println("Saldo: " + cuenta1.getSaldo());
					break;
				case 0:
					System.out.println("Fin del programa.\nGracias por utilizar la aplicación de M03B en el curso 2s2223");
					break;
				default:
					System.out.println("Número introducido no válido");
					break;
			}
		}while(option!=0);
		sc.close();
	}

}
