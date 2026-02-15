package com.security.springSecurity1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.security.springSecurity1.model.Users;
import com.security.springSecurity1.repository.UserRepository;
import com.security.springSecurity1.utils.JwtUtils;

@Service
public class AuthService {
	
	private final UserRepository userRepository;
	private final JwtUtils jwtUtils;	
	private final UserDetailService userDetailService;
	
	public AuthService(UserRepository userRepository, JwtUtils jwtUtils, UserDetailService userDetailService) {
		this.userRepository = userRepository;
		this.jwtUtils = jwtUtils;
		this.userDetailService = userDetailService;
	}



	public String register(Users user) {
		if(userRepository.findByName(user.getName()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exist");
		}
		Users newUser = userRepository.save(user);
		return jwtUtils.generateToken(new UserDetailService().loadUserByUsername(newUser.getName()));
		
	}
	
	public String login(Users user) {
		if(!userRepository.findByName(user.getName()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "User not exist");
		}		
		return jwtUtils.generateToken(new UserDetailService().loadUserByUsername(user.getName()));
		
	}

}
