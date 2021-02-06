package com.hcl.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.springboot.cruddemo.dao.EmployeeDao;
import com.hcl.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;

	@Autowired
	public EmployeeServiceImpl(EmployeeDao thEmployeeDao) {

		employeeDao = thEmployeeDao;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
 
		return employeeDao.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {

		return employeeDao.findById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {

		employeeDao.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
     
		employeeDao.deleteById(theId);
	}

}
