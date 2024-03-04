package BBDDOO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.JDBCType;

public class ConnectDB {
	
	private final String BBDD;
	private final String USER;
	private final String PASSWORD;
	
	public ConnectDB() {
		BBDD = "jdbc:mysql://localhost:3308/";
		USER = "root";
		PASSWORD = "";
	}
	
	public ConnectDB(String bBDD, String uSER, String pASSWORD) {
		super();
		BBDD = bBDD;
		USER = uSER;
		PASSWORD = pASSWORD;
	}

	public void connectToDB() throws SQLException {
		Connection con = DriverManager.getConnection(BBDD,USER,PASSWORD);
		Statement sentencia = con.createStatement();
		
		//Eliminamos el esquema si existe
		String ifExist = "DROP SCHEMA IF EXISTS vt09_m03b;";
		sentencia.executeUpdate(ifExist);
		
		//Creamos el nuevo esquema
		String crearDB = "CREATE DATABASE vt09_m03b;";
		sentencia.executeUpdate(crearDB);
		
		//Usamos el nuevo esquema
		String use = "USE vt09_m03b;";
		sentencia.executeUpdate(use);
		
		//Creamos una tabla 
		String table = "CREATE TABLE ALUMNOS(id_alumno INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(50) NOT NULL);";
		sentencia.executeUpdate(table);
		
		//Insertamos datos en la tabla
		String insert = "INSERT INTO ALUMNOS(nombre) VALUES(\"Alvaro\"),(\"Pedro\"),(\"Maria\"),(\"Paula\");";
		sentencia.executeUpdate(insert);
		
		//Realizamos consulta	
		String res = "SELECT * FROM ALUMNOS;";
		ResultSet result = sentencia.executeQuery(res);
		
		List<Alumno> alumnoList = new ArrayList<>();
		
		while(result.next()) {
			Alumno alumno = new Alumno ((long) result.getInt("id_alumno"),result.getString(2));
			alumnoList.add(alumno);
		}
		
		for (Alumno alumno: alumnoList) {
			System.out.println(alumno.toString());
		}
		
		
		//Cerramos los canales
		result.close();
		sentencia.close();
		con.close();
	}
	
	
}
