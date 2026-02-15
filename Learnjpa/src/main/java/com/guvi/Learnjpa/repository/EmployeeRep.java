package com.guvi.Learnjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guvi.Learnjpa.model.Employee;

@Repository
public interface EmployeeRep extends JpaRepository<Employee, Integer>{
	public Employee findByname(String name);
	
	
	
}
