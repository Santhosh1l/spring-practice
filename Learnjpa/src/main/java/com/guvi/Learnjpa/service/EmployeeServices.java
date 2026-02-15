package com.guvi.Learnjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.guvi.Learnjpa.model.Employee;
import com.guvi.Learnjpa.repository.EmployeeRep;

@Service
public class EmployeeServices {

	@Autowired
	EmployeeRep repo;
	
	
	public  List<Employee> getAllstudents() {
		return repo.findAll();	
	}
	
	
	public  void addEmployee(Employee e) {
		repo.save(e);	
	}
	
	
	public Employee getEmployeeById(int empid) {
		return repo.findById(empid).orElse(new Employee());
	}
	
//
//public void updateEmployee(Employee e) {
//    if (repo.existsById(e.getEmpid())) {
//        repo.save(e);
//    } else {
//        throw new RuntimeException("Employee not found");
//    }
//}

	
	public void deleteEmployeeById(int empid) {
		if(repo.existsById(empid)) {
		repo.deleteById(empid);
		}
	}
	



	public void DeleteAllEmployee() {
		repo.deleteAll();
	}


	public Employee getByEmployeeName(String name) {
		return repo.findByname(name) ;
	}


	public List<Employee> getAllStudentBySorted() {
		List<Employee> e= repo.findAll(Sort.by(Sort.Direction.DESC,"empid"));
		return e;
	}
	
	
}
