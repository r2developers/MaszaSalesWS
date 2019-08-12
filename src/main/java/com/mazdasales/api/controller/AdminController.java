package com.mazdasales.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mazdasales.api.model.User;
import com.mazdasales.api.service.UserService;

@RestController
@RequestMapping("/secure/auth")
public class AdminController {

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	// Add User

	
	  @PreAuthorize("hasAnyRole('ADMIN')")
	  
	  @PostMapping("/admin/add") public String createUser(@RequestBody User user) {
	  
	  String password = user.getPassword(); String encryptPassword =
	  passwordEncoder.encode(password); user.setPassword(encryptPassword);
	  userService.addUser(user);
	  
	  return "User created successfully!"; }
	 

	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/admin/process")
	public String process() {
		return "Processing...";
	}

}
