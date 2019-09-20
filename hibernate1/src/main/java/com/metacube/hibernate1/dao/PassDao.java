package com.metacube.hibernate1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.hibernate1.entities.Employee;
import com.metacube.hibernate1.entities.Pass;
import com.metacube.hibernate1.util.DBQueries;

@Repository
public class PassDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void insertPass(Pass pass) {
		Session session = sessionFactory.getCurrentSession();
        session.save(pass);
	}
}
