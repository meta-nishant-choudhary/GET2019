package com.metacube.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.metacube.pojo.Inventory;
import com.metacube.util.DBConncetion;
import com.metacube.util.DBQueries;
import com.metacube.util.Response;
import com.metacube.enums.Status;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class InventoryDao {
	
	public Status insert(String name, Integer quantity) throws SQLException {
		Connection conn = DBConncetion.getConnection();
		PreparedStatement stmt = conn.prepareStatement(DBQueries.INSERT);
		stmt.setString(1, name);
		stmt.setInt(2, quantity);
		int res = stmt.executeUpdate();
		if(res > 0) {
			return Status.INSERTED;
		}
		return Status.UNSUCCESSFUL;
	}
	
	public Status delete(String name) throws SQLException {
		Connection conn = DBConncetion.getConnection();
		PreparedStatement stmt = conn.prepareStatement(DBQueries.DELETE);
		stmt.setString(1, name);
		int res = stmt.executeUpdate();
		if(res > 0) {
			return Status.DELETED;
		}
		return Status.UNSUCCESSFUL;
	}
	
	public Status deleteAll() throws SQLException {
		Connection conn = DBConncetion.getConnection();
		PreparedStatement stmt = conn.prepareStatement(DBQueries.DELETEALL);
		int res = stmt.executeUpdate();
		if(res > 0) {
			return Status.DELETED;
		}
		return Status.UNSUCCESSFUL;
	}
	
	public Inventory getName(String name) throws SQLException {
		Connection conn = DBConncetion.getConnection();
		PreparedStatement stmt = conn.prepareStatement(DBQueries.GETNAME);
		stmt.setString(1, name);
		ResultSet res = stmt.executeQuery();
		Inventory inventory = new Inventory();
		if(res.next()) {
			inventory.setName(res.getString("name"));
			inventory.setQuantity(res.getInt("quantity"));
			return inventory;
		}
		return null;
		
	}
	
	public List<Inventory> getAll() throws SQLException {
		Connection conn = DBConncetion.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet res = stmt.executeQuery(DBQueries.GETALL);
		List<Inventory> list = new ArrayList<Inventory>();
		while(res.next()) {
			Inventory inventory = new Inventory();
			inventory.setName(res.getString("name"));
			inventory.setQuantity(res.getInt("quantity"));
			list.add(inventory);
		}
		return list;
	}
	
	public Status update(String name, int quantity) throws SQLException {
		Connection conn = DBConncetion.getConnection();
		PreparedStatement stmt = conn.prepareStatement(DBQueries.UPDATE);
		stmt.setInt(1, quantity);
		stmt.setString(2, name);
		int res = stmt.executeUpdate();
		if(res > 0) {
			return Status.UPDATED;
		}
		return Status.UNSUCCESSFUL;
	}
	
	public Status updateAll(String name, Inventory inventory) throws SQLException {
		Connection conn = DBConncetion.getConnection();
		PreparedStatement stmt = conn.prepareStatement(DBQueries.UPDATE);
		stmt.setInt(1, inventory.getQuantity());
		stmt.setString(2, name);
		int res = stmt.executeUpdate();
		if(res > 0) {
			return Status.UPDATED	;
		}
		return Status.UNSUCCESSFUL;
	}
	
	
}