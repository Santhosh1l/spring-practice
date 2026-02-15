package com.project.SpringSecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import com.project.SpringSecurity.Model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer>{
	Users findByname(String name);

}
