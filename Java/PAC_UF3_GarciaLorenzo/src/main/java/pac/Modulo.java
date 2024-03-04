package pac;

import java.util.Set;
import java.util.HashSet;

import jakarta.persistence.*;

@Entity
@Table(name = "modulos")
public class Modulo {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idModulo")
	private long idModulo;
	
	private String nombre;
	private String codigo;
	
	 @ManyToMany(mappedBy = "modulos")
	 private Set<Alumno> alumnos = new HashSet<>();
	
public Modulo() {
		
	}

public Modulo(String nombre, String codigo) {
	super();
	this.nombre = nombre;
	this.codigo = codigo;
	}

public long getIdModulo() {
	return idModulo;
	}

public void setIdModulo(long idModulo) {
	this.idModulo = idModulo;
	}

public String getNombre() {
	return nombre;
	}

public void setNombre(String nombre) {
	this.nombre = nombre;
	}

public String getCodigo() {
	return codigo;
	}

public void setCodigo(String codigo) {
	this.codigo = codigo;
	}

public Set<Alumno> getAlumnos() {
	return alumnos;
}

public void setAlumnos(Set<Alumno> alumnos) {
	this.alumnos = alumnos;
}

@Override
public String toString() {
	return "Insert into modulos, nombre: " + nombre + ", codigo: " + codigo + "/n";
}

}
