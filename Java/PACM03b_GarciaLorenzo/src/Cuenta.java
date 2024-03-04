import java.util.ArrayList;
public class Cuenta {
	//Declaración de atributos
	private double saldo;
	private Usuario usuario;
	private ArrayList<Gasto> gastos;
	private ArrayList <Ingreso> ingresos;
	
	
	//Creación de constructor
	public Cuenta(Usuario usuario) {
		saldo = 0;
		this.usuario = usuario;
		this.gastos = new ArrayList<>();
		this.ingresos = new ArrayList<>();
	}


	//GETTERS Y SETTERS
	public String getSaldo() {
		return String.format("%.2f€",saldo);
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public ArrayList<Gasto> getGastos() {
		return gastos;
	}


	public double addGastos(String description, double cantidad) throws GastoException {
		
		if(saldo<cantidad) {
			throw new GastoException();
		}else {
		Gasto gasto = new Gasto(cantidad,description);
		gastos.add(gasto);
		saldo=saldo-cantidad;
		return saldo;
		}
	}


	public ArrayList<Ingreso> getIngresos() {
		return ingresos;
	}


	public double addIngresos(String description, double cantidad){
		Ingreso ingreso = new Ingreso(cantidad,description);
		ingresos.add(ingreso);
		saldo = saldo+cantidad;
		return saldo;
	}
	
	@Override
	public String toString() {
		return "Usuario: " + usuario + "\nSaldo: " + getSaldo();
	}

	
}
