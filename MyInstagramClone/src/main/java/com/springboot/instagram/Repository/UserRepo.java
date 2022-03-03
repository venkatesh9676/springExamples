package com.springboot.instagram.Repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.instagram.Entity.Users;

@Repository
public interface UserRepo extends CrudRepository<Users, Integer>{

	Users save(Users users);
	Users findByUserId(String userId);
}
