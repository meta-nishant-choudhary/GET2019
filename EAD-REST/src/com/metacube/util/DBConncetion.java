package com.metacube.util;

import java.sql.DriverManager;
import java.sql.Connection;

public class DBConncetion {
	static Connection conn = null;

	public static Connection getConnection() {
		if(conn == null) {
			try {
				Class.forName(DBDetails.DRIVER);
				conn = DriverManager.getConnection(DBDetails.URL, DBDetails.USERNAME, DBDetails.PASSWORD);
				return conn;
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
}