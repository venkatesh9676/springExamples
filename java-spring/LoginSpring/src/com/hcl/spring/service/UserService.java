package com.hcl.spring.service;

import com.hcl.spring.model.Login;
import com.hcl.spring.model.User;

public interface UserService {

	int register(User user);

	  User validateUser(Login login);
}
