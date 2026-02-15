package com.project.musicApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.musicApp.entity.Tracks;

public interface TracksRepository extends JpaRepository<Tracks, Integer> {

}
