package com.security.springSecurity1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.springSecurity1.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{
	Optional<Users> findByName(String name);
	boolean existsByEmail(String email);
}
