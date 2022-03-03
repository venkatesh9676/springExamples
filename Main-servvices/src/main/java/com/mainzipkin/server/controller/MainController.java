package com.mainzipkin.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@GetMapping("/getSleuthTest")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> getSluethTest() {
		LOGGER.info("I'm here in MAin services");
		String response = restTemplate.getForObject("http://localhost:8081/serviceOne", String.class);
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}
}
