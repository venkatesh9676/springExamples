package com.hcl.spring.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.hcl.spring.dao.UserDao;
import com.hcl.spring.model.Login;
import com.hcl.spring.model.User;

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

