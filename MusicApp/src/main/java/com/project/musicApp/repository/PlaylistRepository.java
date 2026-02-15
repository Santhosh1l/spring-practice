package com.project.musicApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.musicApp.entity.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {

}
