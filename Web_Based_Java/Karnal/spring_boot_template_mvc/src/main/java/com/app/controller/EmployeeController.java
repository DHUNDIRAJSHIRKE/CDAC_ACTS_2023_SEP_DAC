package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.pojos.Employee;
import com.app.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService EmployeeService;

	@PostMapping("/show")
	public String getEmployeeForm(Model map, Employee transientEmp, HttpSession session) {
		try {
			map.addAttribute(transientEmp);
		} catch (RuntimeException e) {
			System.out.println("err" + e);
			session.setAttribute("mesg", e.getMessage());
			return "redirect:/index";
		}
		System.out.println("in get method of employee");
		return "/employee/show_details";
	}

	@GetMapping("/add")
	public String addEmployee(Model map, Employee transientEmployee, HttpSession session) {
		System.out.println("in add Empolyee " + transientEmployee);

		return "/employee/add_employee_form";

	}
}
