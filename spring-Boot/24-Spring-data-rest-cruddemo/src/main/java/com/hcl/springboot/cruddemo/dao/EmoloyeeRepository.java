package com.hcl.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.hcl.springboot.cruddemo.entity.Employee;

//@RepositoryRestResource(path="members")
public interface EmoloyeeRepository extends JpaRepository<Employee, Integer> {

	//that's it...no need to write any LOL!
}
