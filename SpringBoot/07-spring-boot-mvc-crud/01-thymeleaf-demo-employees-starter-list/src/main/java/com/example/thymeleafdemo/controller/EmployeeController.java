package com.example.thymeleafdemo.controller;

import com.example.thymeleafdemo.entity.Employee;
import com.example.thymeleafdemo.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService theEmployService){
		employeeService = theEmployService;
	}

	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		//get the employees from db

		List<Employee> theEmployees = employeeService.findAll();

		// add to the spring model
		theModel.addAttribute("employees", theEmployees);

		return "list-employees";
	}
}








