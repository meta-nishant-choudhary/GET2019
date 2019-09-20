package com.metacube.hibernate1.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate.HibernateTemplate;
import org.springframework.stereotype.Repository;








import com.metacube.hibernate1.entities.Employee;
import com.metacube.hibernate1.fascade.FriendMapper;
import com.metacube.hibernate1.util.DBQueries;

@Repository
public class EmployeeDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertEmployee(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		session.save(employee);
	}
	
	public List<Employee> fetchEmployee() {
		Session session = sessionFactory.getCurrentSession();
		List<Employee> empList = session.createQuery("from Employee",Employee.class).list();
		return empList;
	}
	
	public List<Employee> fetchFriend(int id, String org) {
		System.out.println("org fetch = "+ org);
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		List<Employee> empList = (List<Employee>) jdbcTemplate.query(DBQueries.GETFRIEND, new FriendMapper(), id, org);
		System.out.println("ORGAN  =  "+empList.get(1).getOrg());
		return empList;
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
		int emp =  jdbcTemplate.queryForObject(DBQueries.GETLASTEMPLOYEE, Integer.class);
		return emp;
	}
	
	public Employee getEmployeeToEdit(int id) {
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		Employee emp = jdbcTemplate.queryForObject(DBQueries.GETBYID, new FriendMapper(), id);
		return emp;
	}
	
	public Employee getEmployeeById(int id) {
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		return jdbcTemplate.queryForObject(DBQueries.GETBYID, new FriendMapper(), id);
	}
}
