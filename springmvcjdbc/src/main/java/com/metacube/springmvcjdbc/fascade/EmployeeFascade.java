package com.metacube.springmvcjdbc.fascade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.springmvcjdbc.dao.EmployeeDao;
import com.metacube.springmvcjdbc.entities.Employee;

@Component
public class EmployeeFascade {
	
	@Autowired
	EmployeeDao empDao;
	
	public void insertEmployee(Employee employee) {
		empDao.insertEmployee(employee);
	}
	
	public List<Employee> fetchEmployee() {
		return this.empDao.fetchEmployee();
	}
	
	public void updateEmployee(Employee employee) {
		empDao.updateEmployee(employee);
	}
	
	public int getLastInsertedId() {
		return empDao.getLastInsertedId();
	}
	
	public List<Employee> fetchFriend(int id, String org) {
		return empDao.fetchFriend(id, org);
	}
	
	public Employee getEmployeeToEdit(int id) {
		return empDao.getEmployeeById(id);
	}
	
	public Employee getEmployeeById(int id) {
		return empDao.getEmployeeById(id);
	}
}
