
public class Profesores {
	private String nombre;
	private String curso;
	//Metodos GET y SET
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre=nombre;}
	public String getCurso() {return curso;}
	public void setCurso(String curso) {this.curso = curso;}
	
	//Metodos creados por el programador
	public double Evaluar(double nota) {
		nota = nota * 0.8;
		return nota;
	}
}
