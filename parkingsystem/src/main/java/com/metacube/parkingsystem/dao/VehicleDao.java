package com.metacube.parkingsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

import com.metacube.parkingsystem.entities.Vehicle;
import com.metacube.parkingsystem.util.DBConncetion;
import com.metacube.parkingsystem.util.DBQueries;

@Component
public class VehicleDao {
	
	public String insertVehicle(Vehicle vehicle) {
		Connection conn = DBConncetion.getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(DBQueries.INSERTVEHICLE);
			stmt.setString(2, vehicle.getName());
			stmt.setString(3, vehicle.getType());
			stmt.setString(4, vehicle.getNumber());
			stmt.setInt(5, vehicle.getEid());
			stmt.setString(6, vehicle.getIdentification());
			int res = stmt.executeUpdate();
			if(res > 0) {
				return "Vehicle Added Successfully";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "wrong detail";
	}
	
	public int fetchVehicle() {
		Connection conn = DBConncetion.getConnection();
		int id = 0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(DBQueries.FETCHVEHICLE);
			if(res.next()) {
				id = res.getInt(1);
			}
			return id;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
