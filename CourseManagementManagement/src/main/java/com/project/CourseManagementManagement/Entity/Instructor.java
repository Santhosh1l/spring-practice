package com.project.CourseManagementManagement.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Instructor {
	@Id
	private int id;
	
@OneToMany(mappedBy ="instructor", cascade = CascadeType.ALL )
private List<Course> course;
	
}
