package com.guvi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guvi.dto.CreateDto;
import com.guvi.dto.ResponseDto;
import com.guvi.service.StudentService;

@RestController
@RequestMapping("api/v1")
public class StudentController {

	@Autowired
	private StudentService service;
	
	@GetMapping("/")
	public String hellow() {
		return "Hello";
	}
	@PostMapping("/addStudent")
	public ResponseDto addStudent(@RequestBody CreateDto data) {
		return service.create(data);
	}

	@GetMapping("/students")
	public List<ResponseDto> all() {
		return service.findAll();
	}

	@GetMapping("/students/{id}")
	public ResponseDto findById(@PathVariable int id) {
		return service.findById(id);
	}

	

}
