package com.project.CourseManagementManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.CourseManagementManagement.Entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
