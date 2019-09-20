package com.metacube.hibernate1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.hibernate1.entities.Employee;
import com.metacube.hibernate1.entities.Vehicle;
import com.metacube.hibernate1.util.DBQueries;

@Repository
public class VehicleDao {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertVehicle(Vehicle vehicle) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("vehicle = " + vehicle);
		session.save(vehicle);
	}
	
	public int fetchVehicle() {
		RowMapper<Vehicle> rowMapper = new BeanPropertyRowMapper<Vehicle>(Vehicle.class);
		Vehicle veh = jdbcTemplate.queryForObject(DBQueries.FETCHVEHICLE, rowMapper);
		return veh.getId();
	}
}
