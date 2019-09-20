package com.metacube.hibernate1.fascade;

import javax.transaction.TransactionManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.hibernate1.dao.PassDao;
import com.metacube.hibernate1.entities.Pass;

@Service
@Transactional
public class PassFascade {
	
	@Autowired
	private PassDao passDao;
	
	public void insertPass(Pass pass) {
		passDao.insertPass(pass);
	}
}
