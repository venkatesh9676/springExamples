package com.springboot.instagram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.instagram.Entity.Users;
import com.springboot.instagram.Repository.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	
	public Users SubmitMetaDataOfUser(Users users) {
		return userRepo.save(users);
	}
	
	public Users displayUserMetaData(String userid) {
		return userRepo.findByUserId(userid);
	}
}
