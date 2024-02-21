package uf4;

import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.Data;

@Data
public class Usuarito {
	private int id;
	private String nombre; 
	private String apellido;
	private String mail;
	private String telf;
	
	public Usuarito() {
		
	}

	public Usuarito(ResultSet resultSet) throws SQLException {
		this.id = resultSet.getInt(1);
		this.nombre = resultSet.getString(2);
		this.apellido = resultSet.getString(3);
		this.mail = resultSet.getString(4);
		this.telf = resultSet.getString(5);
	}

	public Usuarito(String nombre, String apellido, String mail, String telf) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.telf = telf;
	}
	
	
	
	
}
