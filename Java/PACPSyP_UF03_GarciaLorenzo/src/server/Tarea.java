package server;

public class Tarea {
	private String descripcion;
	private String estado;
	
	public Tarea(String descripcion, String estado) {
		descripcion = this.descripcion;
		estado = this.estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
