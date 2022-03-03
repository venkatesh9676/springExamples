package com.springboot.instagram.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.instagram.Entity.Users;
import com.springboot.instagram.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	
	@Autowired
	UserService userService;
	
	@PostMapping
	private Users submitUser(@RequestBody Users users) {
		return userService.SubmitMetaDataOfUser(users);
		
	}
	
	@GetMapping("/{userId}")
	private Users getUserDetails(@PathVariable("userId") String userId) {
		
		return userService.displayUserMetaData(userId);
	}
}
