package com.security.springSecurity1.filter;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.security.springSecurity1.service.UserDetailService;
import com.security.springSecurity1.utils.JwtUtils;

import io.jsonwebtoken.JwtException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthFilter extends OncePerRequestFilter{
	
	private final JwtUtils jwtUtils;
	private final UserDetailService userService;
	

	public AuthFilter(JwtUtils jwtUtils, UserDetailService userService) {
		this.jwtUtils = jwtUtils;
		this.userService = userService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String header = request.getHeader("Authorization");
		String token = "";
		if(header != null && header.startsWith("Bearer ")) {
			token = header.substring(7);	
			String userName = jwtUtils.getUsername(token);
			if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails userData = userService.loadUserByUsername(userName);
				
				if(jwtUtils.validateToken(token,userData)) {
					UsernamePasswordAuthenticationToken authToken = 
							new UsernamePasswordAuthenticationToken(userName, null, userData.getAuthorities());
					authToken.setDetails(
							new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authToken);
				}
			}
			
			filterChain.doFilter(request, response);
			
		}
		
		
		
	}
	

}
