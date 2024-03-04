package vt07;

public class Ej28Persona {

	//Declaración de atributos
	protected String nombre;
	protected String email;
	
	//Constructores
	public Ej28Persona() {
		super();
	}
	
	//Getters y Setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public boolean setEmail(String email) throws Ejercicio28_EmailException {
		String patronEmail="^[\\w-+]+(\\.[w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		if(email.matches(patronEmail)) {
			this.email=email;
			return true;
		}else {
			throw new Ejercicio28_EmailException();
		}
		
	}
	@Override
	public String toString() {
		return "Persona [nombre= " + nombre + ", email= " + email + "]";
	}

}
