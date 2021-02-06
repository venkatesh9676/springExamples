package com.hcl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dao.UserDao;
import com.hcl.model.Login;
import com.hcl.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	  public UserDao userDao;

	  public int register(User user) {
	    return userDao.register(user);
	  }

	  public User validateUser(Login login) {
	    return userDao.validateUser(login);
	  }

	public List<User> getUser() {
		
		return userDao.getUser();
	}

	public User findUserById(int id) {
		
		return userDao.findUserById(id);
	}

	public void updateUser(User user) {
		
		userDao.updateUser(user);
		
	}

	@Override
	public void deleteUser(int id) {
		
		userDao.deleteUser(id);
		
	}

	

	

	}
