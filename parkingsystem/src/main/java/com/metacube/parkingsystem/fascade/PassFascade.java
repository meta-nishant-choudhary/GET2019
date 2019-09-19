package com.metacube.parkingsystem.fascade;

import org.springframework.beans.factory.annotation.Autowired;

import com.metacube.parkingsystem.dao.PassDao;
import com.metacube.parkingsystem.entities.Pass;

public class PassFascade {
	
	@Autowired
	private PassDao passDao;
	
	public String insertPass(Pass pass) {
		return passDao.insertPass(pass);
	}
}
