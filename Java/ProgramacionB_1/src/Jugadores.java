
public class Jugadores {
	private String nombre;
	private String liga;
	
	public Jugadores() {
		this.nombre = "Equipo";
		this.liga="1";
	}
	
	public Jugadores(String nombre, String liga) {
		this.nombre = nombre;
		this.liga = liga;
	}
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre=nombre;}
	public String getLiga( ) {return liga;}
	public void setLiga(String liga) {this.liga=liga;}
	
	
}

