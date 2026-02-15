package com.security.springSecurity1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.springSecurity1.model.Users;
import com.security.springSecurity1.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private AuthService authService;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Users user) {
		return new ResponseEntity<String>(authService.login(user), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody Users user){
		return new ResponseEntity<String>(authService.register(user), HttpStatus.CREATED);
	}

}
