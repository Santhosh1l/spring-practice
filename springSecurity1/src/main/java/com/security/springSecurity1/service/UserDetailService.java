package com.security.springSecurity1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.springSecurity1.model.UserPrincipal;
import com.security.springSecurity1.model.Users;
import com.security.springSecurity1.repository.UserRepository;

@Service
public class UserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepository.findByName(username).orElse(null);
		if(user == null) throw new UsernameNotFoundException("User Not Found!");
		return new UserPrincipal(user);
	}

}
