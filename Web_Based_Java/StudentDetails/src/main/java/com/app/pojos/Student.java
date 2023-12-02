package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Student")
public class Student extends BaseEntity {
	@Column(name="Roll_No")
	private int rollNo;
	@Override
	public String toString() {
		return "Student [playerId= " + getId() + ",rollNo=" + rollNo + ", firstName=" + firstName + ", lastName=" + lastName + ", city=" + city
				+ ", courseName=" + courseName + "]";
	}





	@Column(length = 20, name = "first_name")
	private String firstName;
	
	@Column(length = 20, name = "last_name")
	private String lastName;
	@Column(length = 20,name = "City")
	private String city ;
	@Column(length = 20,name = "Course_name")
	private String courseName;
	
	
	
	
	
	public Student() {
		super();
	}





	public Student(int rollNo, String firstName, String lastName, String city, String courseName) {
		super();
		this.rollNo = rollNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.courseName = courseName;
	}





	public int getRollNo() {
		return rollNo;
	}





	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}





	public String getFirstName() {
		return firstName;
	}





	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}





	public String getLastName() {
		return lastName;
	}





	public void setLastName(String lastName) {
		this.lastName = lastName;
	}





	public String getCity() {
		return city;
	}





	public void setCity(String city) {
		this.city = city;
	}





	public String getCourseName() {
		return courseName;
	}





	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}





	
	
	
	
	
}
