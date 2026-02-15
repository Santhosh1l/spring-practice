package com.project.musicApp.controller;

import java.util.List;
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


import com.project.musicApp.dto.track.RequestTrackDto;
import com.project.musicApp.dto.track.ResponseTrackDto;

import com.project.musicApp.service.TracksService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/Tracks")
public class TracksController {
	
	@Autowired
	private TracksService  tracksService;

	@GetMapping()
	public ResponseEntity<List<ResponseTrackDto>> getAllPlayList(){
		return ResponseEntity.status(201).body(tracksService.getAllTracks());
	}
	
	@PostMapping()
	public ResponseEntity<ResponseTrackDto> createArtist(RequestTrackDto data) {
		return ResponseEntity.status(HttpStatus.CREATED).body(tracksService.addTracks(data));
	}
	
	@GetMapping("/{trackId}")
	public ResponseEntity<?> getTracksById(@PathVariable("trackId") int id) {

		ResponseTrackDto TrackById = tracksService.getTracksbyId(id);
		if (TrackById != null) {
			return ResponseEntity.status(201).body(TrackById);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Data found");
		}
	}
	
	
	
	@DeleteMapping("/{trackId}")
	public String deleteTrackById(@PathVariable("trackId") int id)
	{
		return tracksService.deleteTrackById(id);
		
	}
	
	@PutMapping("/{trackId}")
	public ResponseEntity<String> updatePlaylist(@PathVariable int trackId,
			@RequestBody RequestTrackDto trackData) {
		String result = tracksService.updateTrack(trackId, trackData);
		if (result.startsWith("No Data Found")) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
		}
		return ResponseEntity.ok(result);
	}
	
	

}
