package com.redasp.pma.controllers;

import java.util.List;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.redasp.pma.dao.IEmployeeRepository;
import com.redasp.pma.dao.IProjectRepository;
import com.redasp.pma.entities.Employee;
import com.redasp.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	IProjectRepository proRepo;
	
	
	@Autowired
	IEmployeeRepository empRepo;
	
	
	@GetMapping
	public String displayProjects(Model model) {
        List<Project> projects =proRepo.findAll();
		model.addAttribute("projects", projects);
		return "projects/listsProject";
		
	}
    
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		
		Project aProject = new Project();		
		List<Employee> employees =empRepo.findAll();
		model.addAttribute("project", aProject);	
		model.addAttribute("allEmployees", employees);	
		return "projects/newProject";
	}

	

	
	@PostMapping("/save")
	public String createProject(Project project,@RequestParam List<Long> employees,BindingResult bindingResult, Model model , RedirectAttributes redirectAttrs) {
	
		//should handle saving to database...
		proRepo.save(project);	
		
		Iterable<Employee> chosenEmployees=empRepo.findAllById(employees);
		
		for(Employee emp : chosenEmployees) {
			emp.setProject(project);
			empRepo.save(emp);
		}
		//use redirect to prevent duplicate submission
		return "redirect:/projects/new";
		//
	}
	
		
	
}
