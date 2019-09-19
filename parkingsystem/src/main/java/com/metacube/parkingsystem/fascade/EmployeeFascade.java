package com.metacube.parkingsystem.fascade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.parkingsystem.dao.EmployeeDao;
import com.metacube.parkingsystem.entities.Employee;

@Component
public class EmployeeFascade {
	
	@Autowired
	EmployeeDao empDao;
	
	public String insertEmployee(Employee employee) {
		return empDao.insertEmployee(employee);
	}
	
	public List<Employee> fetchEmployee() {
		return this.empDao.fetchEmployee();
	}
	
	public String updateEmployee(Employee employee) {
		return empDao.updateEmployee(employee);
	}
	
	public int getLastInsertedId() {
		return empDao.getLastInsertedId();
	}
	
	public List<Employee> fetchFriend(int id, String org) {
		return empDao.fetchFriend(id, org);
	}
	
	public Employee getEmployeeToEdit(int id) {
		return empDao.getEmployeeToEdit(id);
	}
	
	public Employee getEmployeeById(int id) {
		return empDao.getEmployeeById(id);
	}
}
