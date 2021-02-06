package com.hcl.springboot.cruddemo.dao;

import java.util.List;

import com.hcl.springboot.cruddemo.entity.Employee;

public interface EmployeeDao {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee thEmployee);
	
	public void deleteById(int theId);
}
