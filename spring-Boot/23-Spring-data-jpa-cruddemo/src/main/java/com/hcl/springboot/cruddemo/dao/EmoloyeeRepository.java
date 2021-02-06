package com.hcl.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.springboot.cruddemo.entity.Employee;

public interface EmoloyeeRepository extends JpaRepository<Employee, Integer> {

	//that's it...no need to write any LOL!
}
