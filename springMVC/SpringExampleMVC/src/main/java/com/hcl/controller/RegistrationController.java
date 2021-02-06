package com.hcl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.model.PasswordEncoder;
import com.hcl.model.User;
import com.hcl.service.UserService;

@Controller
public class RegistrationController {

	@Autowired
	public UserService userService;

	  @RequestMapping(value = "/register", method = RequestMethod.GET)
	  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("register");
	    mav.addObject("user", new User());
	    return mav;
	
	  }

	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
		@ModelAttribute("user") User user) {
		user.setPassword(PasswordEncoder.getEncoderString(user.getPassword()));
		userService.register(user);
		return new ModelAndView("welcome", "firstname", user.getFirstname());

	}
	
	@GetMapping("/list")
	public String listCoustomer(Model theModel) {
		// get customers from the service
		
		List<User> theUsers = userService.getUser();
       
		// add the customer to the model
		theModel.addAttribute("users", theUsers);

		return "list-users";
	}
	
	
	@RequestMapping("Update") 
	public ModelAndView update(@ModelAttribute User user) {
		
		
		user = userService.findUserById(user.getId());
		
		
		return new ModelAndView("user-form","user",user);
	}
	
	@RequestMapping("rock") 
	public ModelAndView upadateUser(@ModelAttribute User user) {
		System.out.println("hi.........");
		user.setPassword(PasswordEncoder.getEncoderString(user.getPassword()));

		userService.updateUser(user);
		
		return new ModelAndView("redirect:/list");
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteContact(@ModelAttribute User user) {
		
	    userService.deleteUser(user.getId());
	    return new ModelAndView("redirect:/list");
	}
	
	@RequestMapping("search") 
	public ModelAndView serching(@ModelAttribute User user) {
		
		
		user = userService.findUserById(user.getId());
		
		
		return new ModelAndView("user-form","user",user);
	}

}


