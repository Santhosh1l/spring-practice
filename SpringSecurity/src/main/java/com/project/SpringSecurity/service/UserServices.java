package com.project.SpringSecurity.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.project.SpringSecurity.Model.Users;
import com.project.SpringSecurity.repo.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
public class UserServices {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	private JwtService jwtService;
	
	 private BCryptPasswordEncoder encoder= new BCryptPasswordEncoder(12);

	
	
	public Users addUser(Users user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepo.save(user);
	}
	
	public String verify(Users user) {
		Authentication authentication =authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword()));
				
		if(authentication.isAuthenticated()) {
			return  jwtService.generateToken(user.getName());
		}
		return "fail";
	}

}
