package com.metacube.Connection;

import java.sql.DriverManager;
import java.sql.Connection;

public class ConnectionProvider {
	static Connection conn = null;
	private ConnectionProvider() {
		
	}
	
	public static Connection getConnection() {
		if(conn == null) {
			try {
				Class.forName("com.mysql.jdbc.driver");
				conn = DriverManager.getConnection("jdbc.mysql://localhost:3306/store","root", "root");
				return conn;
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
}
