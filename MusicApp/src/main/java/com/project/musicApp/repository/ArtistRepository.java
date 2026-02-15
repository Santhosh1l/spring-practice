package com.project.musicApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.musicApp.entity.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {

}
