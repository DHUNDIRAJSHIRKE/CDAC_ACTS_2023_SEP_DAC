package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.EmployeeDao;
import com.app.pojos.Employee;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public String addEmployee(Employee transientEmployee) {
		
		employeeDao.addEmployee(transientEmployee);
		
		return "Added Employee!!";
	}

}
