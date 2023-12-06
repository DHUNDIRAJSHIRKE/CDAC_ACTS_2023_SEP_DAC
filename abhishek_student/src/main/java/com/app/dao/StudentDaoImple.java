package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Student;

@Repository
public class StudentDaoImple implements StudentDao {

	@Autowired
	private EntityManager manager;

	public StudentDaoImple() {
		System.out.println("7. In Student Dao constructor");

		// TODO Auto-generated constructor stub
	}

	@Override
	public String studentAdd(Student newStudent) {
		System.out.println("12. In Student Dao student add method");

		manager.persist(newStudent);
		
		return "Student Added Successfully";
	}

	@Override
	public List<Student> showStudentPerCourse(String course) {
		String jpql = "SELECT s FROM Student s WHERE s.courseName = :course";
		return manager.createQuery(jpql,Student.class).setParameter("course", course).getResultList();
	}

	@Override
	public List<Student> showAllStudent() {
		String jpqlQuery = "SELECT s FROM Student s";
		return manager.createQuery(jpqlQuery,Student.class).getResultList();
	}

}
