package BBDDOO;

import java.io.Serializable;

public class Alumno implements Serializable {
	
	private Long id;
	private String nombre;
	
	
	public Alumno(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
	
	
}
