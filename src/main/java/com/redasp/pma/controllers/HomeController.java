package com.redasp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.redasp.pma.dao.IEmployeeRepository;
import com.redasp.pma.dao.IProjectRepository;
import com.redasp.pma.entities.Employee;
import com.redasp.pma.entities.Project;

@Controller
public class HomeController {
	
	@Autowired
	IProjectRepository proRepo;
	
	@Autowired
	IEmployeeRepository empRepo;
	
	
	@GetMapping("/")
	public String displayHome(Model model) {
		
		List<Project> projects =proRepo.findAll();
		model.addAttribute("projectsList", projects);
		
		List<Employee> employees =empRepo.findAll();
		model.addAttribute("employeesList", employees);
		
		return "main/home";
	}
	
	

}
