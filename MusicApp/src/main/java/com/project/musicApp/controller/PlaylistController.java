package com.project.musicApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.musicApp.dto.Artist.RequestArtistDto;
import com.project.musicApp.dto.Artist.ResponseArtistDto;
import com.project.musicApp.dto.playlist.RequestPlaylistDto;
import com.project.musicApp.dto.playlist.ResponsePlaylistDto;
import com.project.musicApp.repository.PlaylistRepository;
import com.project.musicApp.service.PlaylistService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {

	@Autowired
	private PlaylistService playlistService;

	@PostMapping("/add")
	public ResponseEntity<ResponsePlaylistDto> createArtist(RequestPlaylistDto data) {
		return ResponseEntity.status(HttpStatus.CREATED).body(playlistService.addPlaylist(data));
	}

	@GetMapping("/{playlistId}")
	public ResponseEntity<?> getPlaylistById(@PathVariable("playlistId") int id) {

		ResponsePlaylistDto playlistByID = playlistService.getPlaylistById(id);
		if (playlistByID != null) {
			return ResponseEntity.status(201).body(playlistByID);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Data found");
		}
	}

	@DeleteMapping("/{playlistId}")
	public String deletePlaylistById(@PathVariable("playlistId") int id) {
		return playlistService.deletePlaylistById(id);
	}

	@PutMapping("/{playlistId}")
	public ResponseEntity<String> updatePlaylist(@PathVariable int playlistId,
			@RequestBody RequestPlaylistDto playlistData) {
		String result = playlistService.updatePlaylist(playlistId, playlistData);
		if (result.startsWith("No Data Found")) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
		}
		return ResponseEntity.ok(result);
	}

}
