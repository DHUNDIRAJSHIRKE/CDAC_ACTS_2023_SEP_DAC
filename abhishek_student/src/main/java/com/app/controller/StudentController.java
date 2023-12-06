package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Student;
import com.app.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	//Using dependencies student service
	@Autowired
	private StudentService studentService;
	
	public StudentController() {
		System.out.println("3. In Student controller constructor");
		System.out.println("4. Moving on to Student service");
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping("/add")
	public String studentAdd(@RequestParam String fn,
			@RequestParam String ln,
			@RequestParam String course,
			Model map) {
		System.out.println("10. In Student controller student add method");
		map.addAttribute("student_add",studentService.studentAdd(new Student(fn,ln,course)));
		return "/student/success";
	}

	@PostMapping("/show_specific")
	public String showStudentPerCourse(@RequestParam String course,Model map) {
		System.out.println("In Student Controller showStudentPerCourse()");
		String key = "specific_course";
		map.addAttribute(key, studentService.showStudentPerCourse(course));
		return "/student/student_specific_list";
	}
	
	@GetMapping("/all_students")
	public String showAllStudent(Model map) {
		System.out.println("In Student Controller showAllStudent()");
		String key = "all_students";
		map.addAttribute(key,studentService.showAllStudent());
		return "/student/student_all_list";
	}
}
