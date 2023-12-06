package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="students")
//@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "dob",callSuper=true)

public class Student extends BaseEntity{
	 

	//id, Rollno, StudentFirstName, StudentLastName, City, CourseName,DoB
	@Column(length=20, unique = true)
	private String rollNo;
	@Column(length=15)
	private String firstName;
	@Column(length=15)
	private String lastName;
	@Column(length=15)
	private String city;
	@Column(length=15)
	private String courseName;
	
	private LocalDate dob;
	
	
	public Student() {
		
	}
	public Student(String rollNo, String firstName, String lastName, String city, String courseName, LocalDate dob) {
		super();
		this.rollNo = rollNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.courseName = courseName;
		this.dob = dob;
	}
}
