package uf2Teoria;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		ConnectDB connect = new ConnectDB(); 
			try {
			connect.connectToDB();
			}catch (SQLException ex) {
				ex.printStackTrace();
			}
	}

}
