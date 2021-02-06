package com.hcl.springboot.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.springboot.thymeleafdemo.entity.Employee;



public interface EmoloyeeRepository extends JpaRepository<Employee, Integer> {

	//that's it...no need to write any LOL!
}
