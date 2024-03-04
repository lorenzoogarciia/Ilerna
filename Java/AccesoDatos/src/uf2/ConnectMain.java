package uf2;

import java.sql.SQLException;

import uf2Teoria.ConnectDB;

public class ConnectMain {

	public static void main(String[] args) {
		ConnectDB connect = new ConnectDBHija(); 
		try {
		connect.connectToDB();
		}catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

}
