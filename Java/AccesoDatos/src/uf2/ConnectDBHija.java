package uf2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import uf2Teoria.ConnectDB;

public class ConnectDBHija extends ConnectDB {

	public void connectToDB() throws SQLException {
		Connection connect = DriverManager.getConnection(BBDD, USER, PASSWORD);
		Statement sentencia = connect.createStatement();
		
		String ifexists  = "DROP SCHEMA IF EXISTS m06accesoDatos;";
		sentencia.executeUpdate(ifexists);
		
		String creaDB = "CREATE DATABASE m06accesodatos;";
		sentencia.executeUpdate(creaDB);
		
		String use = "use m06accesodatos;";
		sentencia.executeUpdate(use);
		
		String crearTabla = "CREATE TABLE Alumnos(id_alumno INT AUTO_INCREMENT PRIMARY KEY, nombre varchar(50) NOT NULL);";
		sentencia.executeUpdate(crearTabla);
		
		String insert = "INSERT INTO Alumnos(nombre) VALUES(\"Lorenzo\"),(\"Paloma\"),(\"Artur\"),(\"Jose\");";
		sentencia.executeUpdate(insert);
		
		ResultSet result = sentencia.executeQuery("SELECT * FROM Alumnos;");
		
		List<Alumno> alumnoList = new ArrayList<>();
		while(result.next()) {
			Alumno alumno = new Alumno((long) result.getInt("id_alumno"), result.getString(2)); 
			alumnoList.add(alumno);
		}
		
		System.out.println("imprimirListaDirectamente: ");
		System.out.println(alumnoList.toString());
		
		System.out.println("Imprimir lisa desde lista: ");
		for(Alumno alum:alumnoList) {
			System.out.println(alum.toString());
		}
		
		result.close();
		sentencia.close();
		connect.close();
	}

}
