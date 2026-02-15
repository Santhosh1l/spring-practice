
package com.project.SpringSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.SpringSecurity.Model.Users;
import com.project.SpringSecurity.service.UserServices;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	
	@Autowired
	private UserServices userServices;
	
	@PostMapping("/add")
	public Users addUser(@RequestBody Users user) {
	
		return userServices.addUser(user);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody Users user) {
		System.out.println("inside controller");
		return userServices.verify(user);
	}
	@GetMapping("/homepage")
	public String homepage() {
		return "User homepage";
	}
}
