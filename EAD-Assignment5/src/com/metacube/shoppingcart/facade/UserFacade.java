package com.metacube.shoppingcart.facade;

import com.metacube.shoppingcart.dao.UserDao;
import com.metacube.shoppingcart.entities.User;

public class UserFacade {
	
	UserDao userDao;
	static UserFacade userFacade=null;
	
	public UserFacade(){
		userDao = new UserDao();
	}
	
	public static UserFacade getInstance() {
		if(userFacade==null) {
			userFacade = new UserFacade();
		}
		return userFacade;
	}
	
	public User addUser(String name) throws Exception {
		User user;
		if(!userDao.checkUser(name)) {
			userDao.addUser(name);
		}
		user = userDao.login(name);
		return user;	
	}

}
