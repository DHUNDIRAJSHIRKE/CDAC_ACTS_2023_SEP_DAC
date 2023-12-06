package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

	@Autowired
	public HomePageController() {
		// TODO Auto-generated constructor stub
		System.out.println("1. In Home Page Controller constructor");
		System.out.println("2. Now going to Student Controller");
	}
	
	@GetMapping("/")
	public String showHomePage() {
		System.out.println("When page 'Student Resistration is open' in browser");
		System.out.println("8. In Home Page Method");
		return "/index";
	}
	
	@GetMapping("/form_add_stu_details")
	public String redirectAddStudentPage() {
		
		System.out.println("9. In Home Page controller showaddstudent()");
		return "/form_add_stu_details";
	}
	
	@GetMapping("/students_per_course")
	public String redirectSpecificStudent() {
		System.out.println("In Home page controller redirectSpecificStudent()");
		return "/students_per_course";
	}

}
