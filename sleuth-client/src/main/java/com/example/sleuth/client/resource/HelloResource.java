package com.example.sleuth.client.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest/hello")
public class HelloResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(HelloResource.class);
	@Autowired 
	private RestTemplate restTemplate;
	
	@GetMapping(value = "/client")
	public String hello() {
		LOGGER.info("Before calling the server");
		String response = restTemplate.getForObject("http://localhost:8081/rest/hello/server", String.class);
		LOGGER.info("After calling the server");
		
		return response;
	}
}
