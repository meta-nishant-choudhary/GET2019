package com.metacube.springmvcjdbc.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.metacube.springmvcjdbc.util.DBQueries;
import com.metacube.springmvcjdbc.entities.Pass;

@Component
public class PassDao {
	
	private JdbcTemplate jdbcTemplate;
	 
	public PassDao(DataSource dataSource) {
	    jdbcTemplate = new JdbcTemplate(dataSource);
	}	
	
	public void insertPass(Pass pass) {
		jdbcTemplate.update(DBQueries.INSERTPASS, pass.getEid(), pass.getType(), pass.getVid(), pass.getPrice(), pass.getPlan());
	}
}
