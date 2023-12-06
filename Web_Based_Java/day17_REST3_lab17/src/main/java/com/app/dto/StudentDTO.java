package com.app.dto;

import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString(exclude = "dob",callSuper=true)

public class StudentDTO {
	 //id, Rollno, StudentFirstName, StudentLastName, City, CourseName,DoB
	@JsonProperty(access = Access.READ_ONLY)
	private Long id; //FOR serialisation , skipped during de serialization
	private String rollNo;
	private String firstName;
	private String lastName;
	private String city;
	private String courseName;
	
	private LocalDate dob;
}
