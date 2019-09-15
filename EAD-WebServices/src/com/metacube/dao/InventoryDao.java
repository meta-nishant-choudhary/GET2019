package com.metacube.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.metacube.Connection.ConnectionProvider;
import com.metacube.pojo.Inventory;

public class InventoryDao {
	
	public String setData(Inventory inventory) {
		try {
			String query = "insert into inventory values('" + inventory.getName() + "','" + inventory.getQuantity() + "');";
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			int res = stmt.executeUpdate(query);
			
			if(res>0) {
				return "Successfully added";
			}
			
			return "unsuccessfull";
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "unsuccessfull";
	}
}
