package com.redasp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.redasp.pma.dao.IEmployeeRepository;
import com.redasp.pma.entities.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	IEmployeeRepository empRepo;
	
	@GetMapping
	public String displayEmployee(Employee employee, Model model) {
        List<Employee> employees =empRepo.findAll();	
		model.addAttribute("employees", employees);
		return "employees/listsEmployee";
		
	}

	
	@GetMapping("/new")
	public String displayEmployeeForm(Employee employee,Model model) {
		
		Employee aEmployee = new Employee();
		model.addAttribute("employee", aEmployee);
		return "employees/newEmployee";
	}
	
	@PostMapping("/save")
	public String createEmployee(Employee employee, Model model) {
		//should handle saving to database...
		empRepo.save(employee);
		//use redirect to prevent duplicate submission
		return "redirect:/employees/new";
		
	}
	
	

}
