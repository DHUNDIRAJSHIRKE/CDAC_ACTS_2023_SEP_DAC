package com.app.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private EntityManager manager;
	
	

	public String addStudent(Student newStudent) {
		
		
		return null;

	}
}
