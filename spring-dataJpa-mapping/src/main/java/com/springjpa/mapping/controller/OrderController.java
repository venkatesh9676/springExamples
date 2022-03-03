package com.springjpa.mapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springjpa.mapping.dto.OrderRequest;
import com.springjpa.mapping.dto.OrderResponse;
import com.springjpa.mapping.model.Customer;
import com.springjpa.mapping.repository.CustomerRepository;
import com.springjpa.mapping.repository.ProductRepository;

@RestController
public class OrderController {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping("/placeOrder")
	public Customer placeOrder(@RequestBody OrderRequest request) {
		return customerRepository.save(request.getCustomer());
	}
	
	@GetMapping("/findAllOrders")
	public List<Customer> findAllOrders(){
		return customerRepository.findAll();
	}
	
	@GetMapping("/getJoinInformation")
	public List<OrderResponse> getJoinInformation(){
		return customerRepository.getJoinInformation();
	}
}
