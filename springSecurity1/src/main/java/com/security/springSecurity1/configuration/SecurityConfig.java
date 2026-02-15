package com.security.springSecurity1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.security.springSecurity1.filter.AuthFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	private final AuthFilter authFilter;
	private final UserDetailsService userService;
	
	
	public SecurityConfig(AuthFilter authFilter,UserDetailsService userService) {
		this.authFilter = authFilter;
		this.userService = userService;
	}


	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) {
		return http.csrf(customizer -> customizer.disable())
				.authorizeHttpRequests(req -> 
						req.requestMatchers("/api/**").authenticated()
							.requestMatchers("/auth/**").permitAll()
							.anyRequest().permitAll())
				.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
	}
	


}
