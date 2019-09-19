package com.metacube.parkingsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.metacube.parkingsystem.entities.Employee;
import com.metacube.parkingsystem.util.DBConncetion;
import com.metacube.parkingsystem.util.DBQueries;

@Component
public class EmployeeDao {
	
	public String insertEmployee(Employee employee) {
		Connection conn = DBConncetion.getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(DBQueries.INSERTEMPLOYEE);
			stmt.setString(1, employee.getName());
			stmt.setString(2, employee.getGender());
			stmt.setString(3, employee.getEmail());
			stmt.setString(4, employee.getPassword());
			stmt.setString(5, employee.getContact());
			stmt.setString(6, employee.getOrg());
			int res = stmt.executeUpdate();
			if(res > 0) {
				return "Employee Added Successfully";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "wrong detail";
	}
	
	public List<Employee> fetchEmployee() {
		List<Employee> employeeList = new ArrayList<Employee>();
		Connection conn = DBConncetion.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(DBQueries.GETEMPLOYEE);
			while(res.next()) {
				Employee employee = new Employee();
				employee.setId(res.getInt("id"));
				employee.setName(res.getString("Name"));
				employee.setGender(res.getString("gender"));
				employee.setPassword(res.getString("password"));
				employee.setEmail(res.getString("Email"));
				employee.setContact(res.getString("Contact"));
				employee.setOrg(res.getString("Organization"));
				employeeList.add(employee);
			}
		}
		catch(SQLException sql) {
			sql.printStackTrace();
		}
		return employeeList;
	}
	
	public List<Employee> fetchFriend(int id, String org) {
		List<Employee> employeeList = new ArrayList<Employee>();
		Connection conn = DBConncetion.getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(DBQueries.GETFRIEND);
			stmt.setInt(1, id);
			stmt.setString(2, org);
			ResultSet res = stmt.executeQuery();
			while(res.next()) {
				Employee employee = new Employee();
				employee.setId(res.getInt("id"));
				employee.setName(res.getString("Name"));
				employee.setGender(res.getString("gender"));
				employee.setPassword(res.getString("password"));
				employee.setEmail(res.getString("Email"));
				employee.setContact(res.getString("Contact"));
				employee.setOrg(res.getString("Organization"));
				employeeList.add(employee);
			}
		}
		catch(SQLException sql) {
			sql.printStackTrace();
		}
		return employeeList;
	}
	
	public String updateEmployee(Employee employee) {
		Connection conn = DBConncetion.getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(DBQueries.UPDATEEMPLOYEE);
			stmt.setString(1, employee.getName());
			stmt.setString(2, employee.getContact());
			stmt.setInt(3, employee.getId());
			int res = stmt.executeUpdate();
			if(res > 0) {
				return "Employee details UPDATED Successfully";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "cannot updated";
	}
	
	public int getLastInsertedId() {
		Connection conn = DBConncetion.getConnection();
		try {
			Employee emp = new Employee();
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(DBQueries.GETLASTEMPLOYEE);
			int id = 0;
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
	
	public Employee getEmployeeToEdit(int id) {
		Employee employeeList = new Employee();
		Connection conn = DBConncetion.getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(DBQueries.GETBYID);
			stmt.setInt(1, id);
			
			ResultSet res = stmt.executeQuery();
			
			if(res.next()) {
				Employee employee = new Employee();
				employee.setId(res.getInt("id"));
				employee.setName(res.getString("Name"));
				employee.setGender(res.getString("gender"));
				employee.setPassword(res.getString("password"));
				employee.setEmail(res.getString("Email"));
				employee.setContact(res.getString("Contact"));
				employee.setOrg(res.getString("Organization"));
				return employee;
			}
		}
		catch(SQLException sql) {
			sql.printStackTrace();
		}
		return null;
	}
	
	public Employee getEmployeeById(int id) {
		Employee employeeList = new Employee();
		Connection conn = DBConncetion.getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(DBQueries.GETBYID);
			stmt.setInt(1, id);
			ResultSet res = stmt.executeQuery();
			if(res.next()) {
				Employee employee = new Employee();
				employee.setId(res.getInt("id"));
				employee.setName(res.getString("Name"));
				employee.setGender(res.getString("gender"));
				employee.setPassword(res.getString("password"));
				employee.setEmail(res.getString("Email"));
				employee.setContact(res.getString("Contact"));
				employee.setOrg(res.getString("Organization"));
				return employee;
			}
		}
		catch(SQLException sql) {
			sql.printStackTrace();
		}
		return null;
	}
}
