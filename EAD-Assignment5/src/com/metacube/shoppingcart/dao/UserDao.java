package com.metacube.shoppingcart.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.metacube.shoppingcart.entities.Product;
import com.metacube.shoppingcart.entities.User;
import com.metacube.shoppingcart.utils.DatabaseConnection;
import com.metacube.shoppingcart.utils.Queries;

public class UserDao {

	public boolean addUser(String name) throws Exception{
		DatabaseConnection dbcon = DatabaseConnection.getInstances();
		PreparedStatement pstmt = dbcon.con.prepareStatement(Queries.ADDUSER);
		pstmt.setString(1, name);
		if(pstmt.executeUpdate()>0){
			return true;
		}
		return false;		
	}
	
	public User login(String name) throws Exception{
		DatabaseConnection dbcon = DatabaseConnection.getInstances();
		PreparedStatement pstmt = dbcon.con.prepareStatement(Queries.LOGIN);
		pstmt.setString(1, name);
		ResultSet rs = pstmt.executeQuery();
		User user =null;
		if(rs.next()){
			user = new User();
			user.setUserId(rs.getInt(1));
			user.setUserName(rs.getString(2));
			return user;
		}
		return null;
	}
	
	public boolean checkUser(String name) throws Exception{
		DatabaseConnection dbcon = DatabaseConnection.getInstances();
		PreparedStatement pstmt = dbcon.con.prepareStatement(Queries.LOGIN);
		pstmt.setString(1, name);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			return true;
		}
		return false;
	}
}
