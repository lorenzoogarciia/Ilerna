
public class Usuario {
	//Declaración de atributos
	private String nombre;
	private int edad;
	private String DNI;
	
	//Declaración de Constructor
	public Usuario() {
		this.nombre="";
		this.edad=0;
		this.DNI="";
	}

	//GETTERS Y SETTERS
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDNI() {
		return DNI;
	}

	public boolean setDNI(String DNI) {
		String patronDNI="\\d{8}[A-Z]";
		if(DNI.matches(patronDNI)) {
			this.DNI=DNI;
			return true;
		}else {
			System.out.println("DNI no válido, vuelva a introducirlo por favor.");
			return false;
		}	
	}
	
	@Override
	public String toString() {
		return "Nombre: " + nombre + "\n Edad: " + edad + "\n DNI: " + DNI;
	}
	
}
