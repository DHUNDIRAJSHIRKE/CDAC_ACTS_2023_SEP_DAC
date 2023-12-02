package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course extends BaseEntity{
	@Column(length = 20, name = "Course_Name")
	private String courseName;

	public Course(String courseName) {
		super();
		this.courseName = courseName;
	}

	public Course() {
		super();
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
}
