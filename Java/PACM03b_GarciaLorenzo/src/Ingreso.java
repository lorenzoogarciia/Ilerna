
public class Ingreso extends Dinero {

	double ingreso;
	//Constructores
	public Ingreso(double ingreso, String description) {
		this.ingreso=ingreso;
		this.description=description;
	}
	
	//Función que devuelve los valores del objeto
	@Override
	public String toString() {
		return "Ingreso: " + ingreso + "\n Descripción: " + description;
	}
}