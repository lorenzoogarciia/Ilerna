package uf4;

import java.sql.Connection;
import java.util.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UsuarioBeanImplement implements UsuarioBean {

	public UsuarioBeanImplement() {
		
	}
	
	public static Connection getConnection() throws SQLException{
		String BBDD = "jdbc:mysql://localhost:3306/m06bean";
		String USER = "root";
		String PASSWORD = "root";
		return DriverManager.getConnection(BBDD,USER,PASSWORD);
	}
	
	@Override
	public List<Usuarito> getUsuarios() throws SQLException {
		List<Usuarito> usuarios = new ArrayList<Usuarito>();
		Statement sentencia = getConnection().createStatement();
		ResultSet resultSet = sentencia.executeQuery("SELECT * FROM Usuarios");
		
		while(resultSet.next()) {
			usuarios.add(new Usuarito(resultSet));
		}
		resultSet.close();
		sentencia.close();
		return usuarios;
	}

	@Override
	public void insertUsuario(Usuarito usuarito) throws SQLException {
		Statement sentencia = getConnection().createStatement();
		String insert = String.format("INSERT INTO Usuarios(nombre, apellido,mail,telf) VALUES");

	}

}
