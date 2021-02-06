package com.hcl.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.springboot.cruddemo.dao.EmoloyeeRepository;

import com.hcl.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmoloyeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmoloyeeRepository theEmployeeRepository) {

		employeeRepository = theEmployeeRepository;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
 
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {

		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee = null;
		if (result.isPresent()) {
			theEmployee = result.get();
			
		}
		else {
			//we didn't find the employee
			throw new RuntimeException("Did not find employee id - " +theId);
		}
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {

		employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
     
		employeeRepository.deleteById(theId);
	}

}
