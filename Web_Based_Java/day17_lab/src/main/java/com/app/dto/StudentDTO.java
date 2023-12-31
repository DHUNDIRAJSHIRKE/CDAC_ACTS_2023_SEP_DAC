package com.app.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 *  Rollno, StudentFirstName, StudentLastName,
City, CourseName,DoB
 */

@Getter
@Setter
@ToString
public class StudentDTO {
	//id property will be added during  ser n skipped during de-ser
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	private String rollNo;
	private String firstName;
	private String lastName;
	private String city;
	private String courseName;
	private LocalDate dob;
}
