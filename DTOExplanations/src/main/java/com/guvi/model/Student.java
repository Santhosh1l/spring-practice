package com.guvi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int deptId = 3118;
	private String fullName;
	private String dept;
	private long collegeNumber = 3;
}
