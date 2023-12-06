package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.StudentDTO;
import com.app.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	public StudentController() {
		// TODO Auto-generated constructor stub
	}
	
	//Add rest api end point to add student details
	//URL http://host:port/students
	//method=POst
	//request payload =  Syudetn DTO
	//respone : sc = 201, StudetnDTo , err: sc=500, api response DTO 
	
	
	@PostMapping
	public ResponseEntity<?> adddNewStudent(@RequestBody StudentDTO dto){
		
		System.out.println("in add new student "+dto);
		
		
		
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(studentService.addStudentDetails(dto));
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			System.out.println("eroor " + e);
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse(e.getMessage()));
			
		}
	}
	
	
	
	
}
