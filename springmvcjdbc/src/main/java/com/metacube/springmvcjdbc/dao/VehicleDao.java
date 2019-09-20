package com.metacube.springmvcjdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.metacube.springmvcjdbc.util.DBQueries;
import com.metacube.springmvcjdbc.entities.Employee;
import com.metacube.springmvcjdbc.entities.Vehicle;

@Component
public class VehicleDao {
	
	private JdbcTemplate jdbcTemplate;
	 
	public VehicleDao(DataSource dataSource) {
	    jdbcTemplate = new JdbcTemplate(dataSource);
	}	
	
	public void insertVehicle(Vehicle vehicle) {
		jdbcTemplate.update(DBQueries.INSERTVEHICLE, vehicle.getName(), vehicle.getType(), vehicle.getNumber(), vehicle.getEid(), vehicle.getIdentification());
	}
	
	public int fetchVehicle() {
		Vehicle vehicle = jdbcTemplate.query(DBQueries.FETCHVEHICLE, new ResultSetExtractor<Vehicle>() {
			 
	        @Override
	        public Vehicle extractData(ResultSet rs) {
	        	Vehicle vehicle = new Vehicle();
	            try {
	            	if(rs.next()) {
	            		System.out.println("fetch vehicle = " + rs.getInt(1));
		            	vehicle.setId(rs.getInt(1));
			            return vehicle;
		            }
	            }
	            catch(SQLException sql) {
	            	sql.printStackTrace();
	            }
				return null;
	       }
	 
	    });
		return vehicle.getEid();
	}
}
