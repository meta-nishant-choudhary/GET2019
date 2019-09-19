package com.metacube.parkingsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.metacube.parkingsystem.entities.Employee;
import com.metacube.parkingsystem.entities.Pass;
import com.metacube.parkingsystem.util.DBConncetion;
import com.metacube.parkingsystem.util.DBQueries;

public class PassDao {
	
	public String insertPass(Pass pass) {
		Connection conn = DBConncetion.getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(DBQueries.INSERTPASS);
			stmt.setInt(1, pass.geteId());
			stmt.setString(2, pass.getType());
			stmt.setInt(3, pass.getvId());
			stmt.setString(4, pass.getPrice());
			stmt.setString(5, pass.getPlan());
			int res = stmt.executeUpdate();
			if(res > 0) {
				return "Pass Added Successfully";
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return "wrong detail";
	}
}
