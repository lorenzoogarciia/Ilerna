package uf2Teoria;
import java.sql.*;

public class ConnectDB {
	
	protected final String BBDD;
	protected final String USER;
	protected final String PASSWORD;
	
	public ConnectDB() {
		this.BBDD = "jdbc:mysql://localhost:3306";
		this.USER = "root";
		this.PASSWORD = "root";
	}
	
	public ConnectDB(String bbdd, String user, String password) {
		this.BBDD = bbdd;
		this.USER = user;
		this.PASSWORD = password;
	}
	
	public void connectToDB() throws SQLException {
		Connection connect = DriverManager.getConnection(BBDD, USER, PASSWORD);
		Statement sentencia = connect.createStatement();
		System.out.println("CONEXION CON MYSQL Y JDBC COMPLETA");
		sentencia.close();
		connect.close();
	}
}
