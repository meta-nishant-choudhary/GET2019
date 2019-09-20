package com.metacube.hibernate1.fascade;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.hibernate1.entities.Employee;

public class FriendMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet res, int rowNum) throws SQLException {
		Employee emp = new Employee();
		emp.setId(res.getInt(1));
		emp.setName(res.getString(2));
		emp.setGender(res.getString(3));
		emp.setEmail(res.getString(4));
		emp.setContact(res.getString(6));
		emp.setOrg(res.getString(7));
		return emp;
	}
	
}
