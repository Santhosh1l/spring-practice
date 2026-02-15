package com.guvi.Learnjpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empid;

    private String name;
    private double salary;
    private String department;
    private String employeeType;

   
    public String getEmployeeType() {
		return employeeType;
	}


	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}


	public Employee() {}

    
    public int getEmpid() {
		return empid;
	}


	public void setEmpid(int empid) {
		this.empid = empid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public Employee(String name, double salary, String department,String employeeType) {
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.employeeType= employeeType;
    }

   
}
