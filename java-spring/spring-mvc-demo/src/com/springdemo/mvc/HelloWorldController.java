package com.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	//new Controller method to read form data and
	//add data to the model
	
	@RequestMapping("/processForm2")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		//read the request parameter from the html form
		String theName=request.getParameter("studentName");
		
		//convert the data to all caps
		theName=theName.toUpperCase();
		
		//create the message
		String result="YO!"+theName;
		
		//add message to the model
	    model.addAttribute("message", result);
	    
		return "helloworld";
	}
	
	@RequestMapping("/processForm3")
	public String processForm3(@RequestParam("studentName") String theName, Model model) {
		
		
		
		//convert the data to all caps
		theName=theName.toUpperCase();
		
		//create the message
		String result="Hey My Friend!"+theName;
		
		//add message to the model
	    model.addAttribute("message", result);
	    
		return "helloworld";
	}

	
	
	
	
}
