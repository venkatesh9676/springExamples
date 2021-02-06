package com.hcl.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.springboot.thymeleafdemo.entity.Employee;



public interface EmoloyeeRepository extends JpaRepository<Employee, Integer> {

	//that's it...no need to write any LOL!
	
	//add a method to sort by lastName
	public List<Employee> findAllByOrderByLastNameAsc();
}
