package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.StudentDao;
import com.app.pojos.Student;

@Service
@Transactional
public class StudentService {

	@Autowired
	private StudentDao studentDao;
	
	public StudentService() {
		// TODO Auto-generated constructor stub
		System.out.println("5. In Student Service constructor");
		System.out.println("6. Moving on to Student Dao");

	}
	
	public String studentAdd(Student newStudent) {
		System.out.println("11. In Student service student add method");
		return studentDao.studentAdd(newStudent);
	}
	

	public List<Student> showStudentPerCourse(String course) {
		// TODO Auto-generated method stub
		System.out.println("In Student service showStudentPerCourse()");
		return studentDao.showStudentPerCourse(course);
	}

	public List<Student> showAllStudent() {
		System.out.println("In Student service showAllStudent()");
		return studentDao.showAllStudent();
	}
	
	

}
