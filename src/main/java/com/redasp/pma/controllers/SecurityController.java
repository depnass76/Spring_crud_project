package com.redasp.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.redasp.pma.dao.IUserAccountRepository;

import com.redasp.pma.entities.UserAccount;
import com.redasp.pma.services.EmployeeService;

@Controller
public class SecurityController {
	
	
    @Autowired
    IUserAccountRepository accountRepo;
    
	@Autowired
	BCryptPasswordEncoder bCryptEncoder;
	
	@Autowired
	EmployeeService serviceRepo;
	
	@GetMapping("/register")
	public String register(Model model)
	{
		UserAccount userAccount = new UserAccount();
		model.addAttribute("userAccount",userAccount );
		
		return "security/register";
		
	}
	
	@PostMapping("register/save")
	public String saveUser(Model model, UserAccount user)
	{
		user.setPassword(bCryptEncoder.encode(user.getPassword()));
		accountRepo.save(user);
		
		return "redirect:/";
	}

}
