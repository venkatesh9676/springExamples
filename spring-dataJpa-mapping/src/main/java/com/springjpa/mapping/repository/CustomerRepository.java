package com.springjpa.mapping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springjpa.mapping.dto.OrderResponse;
import com.springjpa.mapping.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	@Query("SELECT new com.springjpa.mapping.dto.OrderResponse(c.name , p.productName) FROM Customer c JOIN c.products p")
	public List<OrderResponse> getJoinInformation();

}
