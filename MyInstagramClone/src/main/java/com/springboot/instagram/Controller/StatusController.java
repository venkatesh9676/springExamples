package com.springboot.instagram.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.instagram.Entity.Status;
import com.springboot.instagram.service.StatusService;

@RestController
@RequestMapping("/status")
public class StatusController {

	@Autowired
	StatusService statusService;
	@PostMapping
	private Status submitStatus(@RequestBody Status status) {
		return statusService.submitDataIntoDB(status);
	}
	
	@GetMapping("/All")
	private ArrayList<Status> getAllStatus() {
		return statusService.retrieveStatus();
	}
}
