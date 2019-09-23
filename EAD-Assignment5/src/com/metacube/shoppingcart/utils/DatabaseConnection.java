package com.metacube.shoppingcart.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {
	
private static DatabaseConnection conn;
	
	public static Connection con;
	
	public static DatabaseConnection getInstances()
	{
		if(conn==null)
		{
			try {
				DatabaseConnection.conn =  new DatabaseConnection();
			} catch (Exception e) {
								e.printStackTrace();
			}
		}
		return conn;
	}
	
	private DatabaseConnection() throws Exception
	{
		Class.forName(DbDetails.DRIVER);
		this.con = DriverManager.getConnection(DbDetails.URL,DbDetails.USERNAME,DbDetails.PASSWORD);
	}


}
