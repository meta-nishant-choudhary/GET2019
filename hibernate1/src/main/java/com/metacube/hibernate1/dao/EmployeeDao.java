package com.metacube.hibernate1.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.hibernate1.entities.Employee;

import com.metacube.hibernate1.util.DBQueries;

@Repository
public class EmployeeDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void insertEmployee(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		session.save(employee);
	}
	
	public List<Employee> fetchEmployee() {
		Session session = sessionFactory.getCurrentSession();
		List<Employee> empList = session.createQuery("from Employee",Employee.class).list();
		return empList;
	}
	
	//code updated
	public List<Employee> fetchFriend(int id, String org) {
		Session session = sessionFactory.getCurrentSession();
		String query = "from Employee where id <> " + id +" and organization='"+ org + "'";
		return session.createQuery(query, Employee.class).getResultList();
	}
	
	public Employee updateEmployee(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		Employee emp =(Employee)session.get(Employee.class, employee.getId());
		emp.setName(employee.getName());
		emp.setContact(employee.getContact());
		session.save(emp);
		return emp;
	}
	
	public int getLastInsertedId() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("select max(id) from Employee", Integer.class).getSingleResult();
	}
	
	public Employee getEmployeeToEdit(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Employee.class, id);
	}
	
	public Employee getEmployeeById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Employee.class, id);
	}
	
	public Employee getEmployeeByEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Employee.class, email);
	}
	
}
