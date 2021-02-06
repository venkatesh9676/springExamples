package com.javatpoint.dao;

import com.javatpoint.beans.Login;
import com.javatpoint.beans.User;

public interface UserDao {

	 int register(User user);
	 
	 User validateUser(Login login);
}
