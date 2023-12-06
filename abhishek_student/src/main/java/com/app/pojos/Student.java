package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentRoll;

	@Column(name = "first_name", length = 30)
	private String studentFirstName;

	@Column(name = "last_name", length = 30)
	private String studentLastName;

	@Column(name = "course", length = 30)
	private String courseName;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String studentFirstName, String studentLastName, String courseName) {
		super();
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
		this.courseName = courseName;
	}

	public Integer getStudentRoll() {
		return studentRoll;
	}

	public void setStudentRoll(Integer studentRoll) {
		this.studentRoll = studentRoll;
	}

	public String getStudentFirstName() {
		return studentFirstName;
	}

	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}

	public String getStudentLastName() {
		return studentLastName;
	}

	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}

	public String getCourseName() {
		return courseName;
	}

	@Override
	public String toString() {
		return "Student [studentRoll=" + studentRoll + ", studentFirstName=" + studentFirstName + ", studentLastName="
				+ studentLastName + ", courseName=" + courseName + "]";
	}
}
