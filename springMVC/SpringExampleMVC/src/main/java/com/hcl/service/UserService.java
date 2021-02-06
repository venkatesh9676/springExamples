package com.hcl.service;

import java.util.List;

import com.hcl.model.Login;
import com.hcl.model.User;

public interface UserService {

	int register(User user);

	  User validateUser(Login login);
	  public List<User> getUser();


	public User findUserById(int id);

	public void updateUser(User user);

	public void deleteUser(int id);  
	
}
