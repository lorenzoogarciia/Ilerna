
public class Gasto extends Dinero{

	double gasto;
	//Constructores
	public Gasto(double gasto, String description) {
		this.gasto=gasto;
		this.description=description;
	}
	
	@Override
	public String toString() {
		return "Gasto: " + gasto + "\nDescripción: " + description;
	}
}
