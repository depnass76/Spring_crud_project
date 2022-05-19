package com.redasp.pma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.redasp.pma.dao.IEmployeeRepository;
import com.redasp.pma.dao.IProjectRepository;

@SpringBootApplication
public class ProjectManagementApplication {
	
	@Autowired
	IEmployeeRepository empRep;
	
	@Autowired
	IProjectRepository projRep;
	


	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}

}
