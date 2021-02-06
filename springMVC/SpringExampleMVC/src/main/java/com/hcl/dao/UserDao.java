package com.hcl.dao;

import java.util.List;

import com.hcl.model.Login;
import com.hcl.model.User;

public interface UserDao {

	 int register(User user);
	 
	 User validateUser(Login login);

	public List<User> getUser();

	public User findUserById(int id);

	public void updateUser(User user);

	public void deleteUser(int id);
}
