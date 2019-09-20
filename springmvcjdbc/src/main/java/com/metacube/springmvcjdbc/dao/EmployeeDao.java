package com.metacube.springmvcjdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.metacube.springmvcjdbc.entities.Employee;
import com.metacube.springmvcjdbc.util.DBQueries;

@Component
public class EmployeeDao {

	private JdbcTemplate jdbcTemplate;
	 
	public EmployeeDao(DataSource dataSource) {
	    jdbcTemplate = new JdbcTemplate(dataSource);
	}	
	
	/**
	 * method to insert employee
	 */
	public void insertEmployee(Employee employee) {
		jdbcTemplate.update(DBQueries.INSERTEMPLOYEE, employee.getName(), employee.getGender(), employee.getEmail(), employee.getPassword(), 
				employee.getContact(), employee.getOrg());
		
	}

	public Employee getEmployeeById(int id) {
		String GETBYID = "select * from employee where id="+ id + ";";
	    return jdbcTemplate.query(GETBYID, new ResultSetExtractor<Employee>() {
	 
	        @Override
	        public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
	        	
	        	if(rs.next()) {
		        	Employee employee = new Employee();
		            try {
			            employee.setId(rs.getInt("id"));
			            employee.setName(rs.getString("Name"));
			            employee.setGender(rs.getString("gender"));
			            employee.setEmail(rs.getString("Email"));
			            employee.setPassword(rs.getString("password"));
			            employee.setContact(rs.getString("Contact"));
			            employee.setOrg(rs.getString("Organization"));
			            return employee;
		            }
		            catch(SQLException sql) {
		            	sql.printStackTrace();
		            }
	        	}
				return null;
	        }
	 
	    });
	}
	
	public List<Employee> fetchFriend(int id, String org) {
		String GETFRIEND = "select * from employee where id!=" + id + " and Organization='"+ org +"';";
		List<Employee> friendList = jdbcTemplate.query(GETFRIEND, new RowMapper<Employee>() {
			 
	        @Override
	        public Employee mapRow(ResultSet rs, int rowNum) {
	            Employee employee = new Employee();
	            try {
		            employee.setId(rs.getInt("id"));
		            employee.setName(rs.getString("Name"));
		            employee.setGender(rs.getString("gender"));
		            employee.setEmail(rs.getString("Email"));
		            employee.setPassword(rs.getString("password"));
		            employee.setContact(rs.getString("Contact"));
		            employee.setOrg(rs.getString("Organization"));
		            return employee;
	            }
	            catch(SQLException sql) {
	            	sql.printStackTrace();
	            }
				return null;
	       }
	 
	    });
		return friendList;
	}
	
	//correct
	public List<Employee> fetchEmployee() {
		
	    List<Employee> employeeList = jdbcTemplate.query(DBQueries.GETEMPLOYEE, new RowMapper<Employee>() {
	 
	        @Override
	        public Employee mapRow(ResultSet rs, int rowNum) {
	            Employee employee = new Employee();
	            try {
		            employee.setId(rs.getInt("id"));
		            employee.setName(rs.getString("Name"));
		            employee.setGender(rs.getString("gender"));
		            employee.setEmail(rs.getString("Email"));
		            employee.setPassword(rs.getString("password"));
		            employee.setContact(rs.getString("Contact"));
		            employee.setOrg(rs.getString("Organization"));
		            return employee;
	            }
	            catch(SQLException sql) {
	            	sql.printStackTrace();
	            }
				return null;
	       }
	 
	    });
	    return employeeList;
	}

	public void updateEmployee(Employee employee) {
		jdbcTemplate.update(DBQueries.UPDATEEMPLOYEE, employee.getName(), employee.getContact(), employee.getId());
	}
	
	public int getLastInsertedId() {
		Employee employee = jdbcTemplate.query(DBQueries.GETLASTEMPLOYEE, new ResultSetExtractor<Employee>() {
			
			@Override
	        public Employee extractData(ResultSet rs) {
	            try {
	            	if(rs.next()) {
		            	Employee employee = new Employee();
			            employee.setId(rs.getInt(1));
			            return employee;
	            	}
	            }
				catch(SQLException e) {
					e.printStackTrace();
				}
	            return null;
	        }
		});
		return employee.getId();
	}
}
