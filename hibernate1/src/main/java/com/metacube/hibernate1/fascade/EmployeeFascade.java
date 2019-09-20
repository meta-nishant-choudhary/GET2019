package com.metacube.hibernate1.fascade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.hibernate1.dao.EmployeeDao;
import com.metacube.hibernate1.entities.Employee;

@Service
@Transactional
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
		return empDao.getEmployeeToEdit(id);
	}
	
	public Employee getEmployeeById(int id) {
		return empDao.getEmployeeById(id);
	}
}
