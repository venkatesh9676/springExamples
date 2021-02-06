package com.javatpoint.service;

import com.javatpoint.beans.Login;
import com.javatpoint.beans.User;

public interface UserService {

	int register(User user);

	  User validateUser(Login login);
}
