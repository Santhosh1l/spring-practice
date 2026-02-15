package com.guvi.MusicStreaming.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guvi.MusicStreaming.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
