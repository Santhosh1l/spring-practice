package com.project.CourseManagementManagement.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Student {
	@Id
	private int id;
	
	@OneToOne(mappedBy = "student")
	private Address address;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="Student_course", 
		joinColumns = {@JoinColumn(name="Student_id",referencedColumnName = "id")},
		inverseJoinColumns = {@JoinColumn(name="course_id",referencedColumnName = "course_id")})
	private List<Course> course;
				
}
