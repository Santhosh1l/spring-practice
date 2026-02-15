package com.guvi.Learnjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guvi.Learnjpa.Dto.EmployeeDto;
import com.guvi.Learnjpa.model.*;
import com.guvi.Learnjpa.service.EmployeeServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
@Validated
public class EmployeeController {
	@Autowired
	EmployeeServices es;
	
	@GetMapping("/hello")
	public String print() {
	 	return "hello";
	}
	@GetMapping
	public List<Employee> getAllStudents(){
		return es.getAllstudents();
	}

@PostMapping("/employee")
public ResponseEntity<String> addStudent(@Valid @RequestBody EmployeeDto dto) {
	Employee employee = new Employee(dto.getName(), dto.getSalary(), dto.getDepartment(),dto.getEmployeeType());
    es.addEmployee(employee);

    return ResponseEntity.status(HttpStatus.CREATED).body("Employee Added Successfully");
}


	@GetMapping("/employee/{empid}")
	public Employee getEmployeeById(@PathVariable("empid")int empid) {
		return es.getEmployeeById(empid);
	}
	
//	@PutMapping("/employee")
//	public String updateEmployee(@RequestBody Employee e) {
//		es.updateEmployee(e);
//		return "Updated";
//	}
	
	@GetMapping("/sorted")
	public List<Employee> getAllstudentsSorted(){
		return es.getAllStudentBySorted();
	}
	

	@DeleteMapping("/employee/{empid}")
	public String deleteEmployeeById(@PathVariable int empid) {
    es.deleteEmployeeById(empid);
    return "Deleted----";
}
	

	

	
}
