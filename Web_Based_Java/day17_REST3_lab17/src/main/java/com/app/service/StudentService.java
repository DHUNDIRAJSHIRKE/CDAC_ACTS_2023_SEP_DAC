package com.app.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.app.dto.StudentDTO;
import com.app.entities.Student;


public interface StudentService {
	
	
	StudentDTO addStudentDetails(StudentDTO s1);
}
