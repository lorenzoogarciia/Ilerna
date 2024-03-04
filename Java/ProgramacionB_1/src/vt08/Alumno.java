package vt08;

import vt07.Ej28Persona;

public class Alumno extends Ej28Persona {
	private String apellido;
	private int edad;
	private String[] modulos;
	
	public Alumno(String nombre, String apellido, int edad, String email, String[] modulos) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.edad=edad;
		this.email=email;
		this.modulos=modulos;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String[] getModulos() {
		return modulos;
	}

	public void setModulos(String[] modulos) {
		this.modulos = modulos;
	}
	
	
}
