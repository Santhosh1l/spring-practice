
package com.project.SpringSecurity.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

	
	@GetMapping("/")
		public String summa() {
			return "security";
		}
	
	@GetMapping("/hello")
	public String sayHello() {
		return "hello";
	}
	@GetMapping("/public/demo")
	public String demo() {
		return "Public page";
	}
	
	
	@GetMapping("/hai")
	public String sayHai() {
		return "hai";
	}
	@GetMapping("/csrf")
	public CsrfToken getCsrfTokern(HttpServletRequest req) {
		return (CsrfToken) req.getAttribute("_csrf");
	}
}
