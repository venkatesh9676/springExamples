package com.hcl.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.hcl.springboot.cruddemo.entity.Employee;

public class EmployeeDaoJpaImpl implements EmployeeDao {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDaoJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {

		// create a query
		Query theQuery = entityManager.createQuery("from Employee");

		// execute query and get result list
		List<Employee> employees = theQuery.getResultList();

		// return the results
		return employees;
	}

	@Override
	public Employee findById(int theId) {

		// get employee

		Employee theEmployee = entityManager.find(Employee.class, theId);
		// return employee
		return theEmployee;
	}

	@Override
	public void save(Employee thEmployee) {

		// save or update the employee
		Employee dbEmployee = entityManager.merge(thEmployee);

		// update with id from db.. so we can get generated id for save/update
		thEmployee.setId(dbEmployee.getId());

	}

	@Override
	public void deleteById(int theId) {

		// delete object with primaru key
		Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");

		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();

	}

}
