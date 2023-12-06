package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.pojos.Student;
import com.app.service.StudentServiceImpl;

@Controller
@RequestMapping("/students")
public class StudentController {
//  http://localhost:8080/ctx_path/players/add
	@Autowired
	private StudentServiceImpl studentService;
	
	
	@PostMapping("/add")
	public String addPlayer(Model map, Student transientStudent,
			HttpSession session)

	{
		System.out.println("in add player " + transientStudent + " " + transientStudent.getFirstName()+" "+transientStudent.getLastName());
		// Create transient Player object n pass it to PlayerService layer
		try {
			map.addAttribute("mesg",
					studentService.addStudent(transientStudent));
		} catch (RuntimeException e) {
			System.out.println("err " + e);
			//save err mesg in the session scope : since using a redirect here.
			session.setAttribute("mesg", e.getMessage());
			// in case of any errs : redirect the clnt to the TeamController again, as a
			// next request coming from the clnt
			return "redirect:/index";
		}
		return "/student/show";
	}

}
