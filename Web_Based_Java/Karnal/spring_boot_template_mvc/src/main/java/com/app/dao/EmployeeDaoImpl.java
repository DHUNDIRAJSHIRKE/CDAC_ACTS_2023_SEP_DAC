package com.app.dao;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.app.pojos.Employee;
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private EntityManager mgr;
	
	@Override
	public String addEmployee(Employee transientEmployee) {
		
		try {
			mgr.persist(transientEmployee);
		}catch(RuntimeException e) {
			System.out.println("err "+e);
			
		}
		
		
		return "Employee Added Successfully!!!";
	}

}
