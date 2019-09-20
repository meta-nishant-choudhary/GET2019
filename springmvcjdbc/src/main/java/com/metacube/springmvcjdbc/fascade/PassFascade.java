package com.metacube.springmvcjdbc.fascade;

import org.springframework.beans.factory.annotation.Autowired;

import com.metacube.springmvcjdbc.dao.PassDao;
import com.metacube.springmvcjdbc.entities.Pass;

public class PassFascade {
	
	@Autowired
	private PassDao passDao;
	
	public void insertPass(Pass pass) {
		passDao.insertPass(pass);
	}
}
