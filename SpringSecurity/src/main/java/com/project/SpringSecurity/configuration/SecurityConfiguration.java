package com.project.SpringSecurity.configuration;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
public class SecurityConfiguration {
	
@Autowired
UserDetailsService userDetailsServices;

@Autowired
private JwtFilter jwtfilter;

	
	@Bean
	public SecurityFilterChain securityFilterchain(HttpSecurity http) throws Exception {
		return http.csrf(customizer -> customizer.disable())
				.authorizeHttpRequests(request -> request
						.requestMatchers("/user/**").permitAll()
						.anyRequest().authenticated())
						.httpBasic(Customizer.withDefaults())
						.sessionManagement(session ->
							session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
						.addFilterBefore(jwtfilter,UsernamePasswordAuthenticationToken.class)
						.build();
	}
	
	// multiple user8
//	@Bean
//	public UserDetailsService userDetailService() {
//		List<UserDetails> users= new ArrayList();
//		UserDetails user1= User.withDefaultPasswordEncoder().username("malik")
//							.password("2345")
//							.roles("User1")
//							.build();
//		UserDetails user2= User.withDefaultPasswordEncoder().username("samna")
//				.password("345")
//				.roles("User2")
//				.build();
//		users.add(user1);
//		users.add(user2);
//		
//		
//		return new InMemoryUserDetailsManager(users);
//		
//		
//	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider= new DaoAuthenticationProvider();
		provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		provider.setUserDetailsService(userDetailsServices);
		return provider;
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
		
	}
	
	
}
