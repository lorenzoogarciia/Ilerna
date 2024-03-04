package pac;

import java.util.Set;


import java.util.HashSet;

import jakarta.persistence.*;

@Entity
@Table(name = "alumnos")
public class Alumno {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAlumno")
	private long idAlumno;
	
	private String nombre;
	private String nacionalidad;
	private String sexo;
	private int edad;
	
    	@ManyToMany()
	    @JoinTable(
	        name = "alumno_modulo",
	        joinColumns = @JoinColumn(name = "idAlumno"),
	        inverseJoinColumns = @JoinColumn(name = "idModulo")
	    )

	private Set<Modulo> modulos = new HashSet<>();
	
	public Alumno() {
		
	}
	
	public Alumno(String nombre, String nacionalidad, int edad, String sexo, Set<Modulo> modulos) {
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.edad = edad;
		this.sexo = sexo;
		this.modulos = modulos;
	}
	

	public long getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(long idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNacionalidad() {
		return nacionalidad;
	}
	
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Set<Modulo> getModulos() {
		return modulos;
	}

	public void setModulos(Set<Modulo> modulos) {
		this.modulos = modulos;
	}

	@Override
	public String toString() {
		return "Insert into alumnos, nombre: " + nombre + ", nacionalidad: " + nacionalidad + 
				", edad: " + edad + ", sexo: " + sexo + ", modulos: " + modulos +"/n";
	}


	
	
}
