package com.project.musicApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.project.musicApp.dto.Artist.RequestArtistDto;
import com.project.musicApp.dto.Artist.ResponseArtistDto;
import com.project.musicApp.dto.playlist.RequestPlaylistDto;
import com.project.musicApp.entity.Artist;
import com.project.musicApp.service.ArtistService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/artist")
public class ArtistController {
	@Autowired
	private ArtistService artistService;
	
	@PostMapping("/add")
	public ResponseEntity<ResponseArtistDto> createArtist(RequestArtistDto data) {
		return ResponseEntity.status(HttpStatus.CREATED).body(artistService.addArtist(data));
	}
	@GetMapping()
	public ResponseEntity<List<ResponseArtistDto>> getAllArtist(){
		return ResponseEntity.status(201).body(artistService.getAllArtist());
	}
	
	@GetMapping("/{Id}")
	public ResponseEntity<?> getArtistById(@PathVariable("Id") int id){
	
		ResponseArtistDto artistBy=artistService.getArtistById(id);
		if(artistBy!=null) {
			return ResponseEntity.status(201).body(artistBy);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Data found");
		}
	}
	
	@PutMapping("{Id}")
	public ResponseEntity<String> updateArtistById(@PathVariable("Id") int id,@RequestBody RequestArtistDto artistdata){
		return ResponseEntity.status(201).body(artistService.updateArtist(id, artistdata));
		
	}
	
	
	
   @DeleteMapping("/{id}")
   public String deleteArtist(@PathVariable("id") int id) {
	return artistService.deleteArtist(id);
	   
   }
}
