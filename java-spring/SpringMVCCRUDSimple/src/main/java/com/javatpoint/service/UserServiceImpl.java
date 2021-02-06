package com.javatpoint.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.javatpoint.beans.Login;
import com.javatpoint.beans.User;
import com.javatpoint.dao.UserDao;


public class UserServiceImpl implements UserService {

	@Autowired
	  public UserDao userDao;

	  public int register(User user) {
	    return userDao.register(user);
	  }

	  public User validateUser(Login login) {
	    return userDao.validateUser(login);
	  }

	}

