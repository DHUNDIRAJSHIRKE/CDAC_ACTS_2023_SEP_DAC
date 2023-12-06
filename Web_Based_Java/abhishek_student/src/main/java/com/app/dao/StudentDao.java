package com.app.dao;

import java.util.List;

import com.app.pojos.Student;

public interface StudentDao {
	String studentAdd(Student newStudent);

	List<Student> showStudentPerCourse(String course);

	List<Student> showAllStudent();
}
