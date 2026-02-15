package com.project.musicApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.musicApp.dto.Artist.RequestArtistDto;
import com.project.musicApp.dto.Artist.ResponseArtistDto;
import com.project.musicApp.dto.playlist.RequestPlaylistDto;
import com.project.musicApp.dto.playlist.ResponsePlaylistDto;
import com.project.musicApp.entity.Artist;
import com.project.musicApp.entity.Playlist;
import com.project.musicApp.mapper.ArtistMapper;
import com.project.musicApp.mapper.PlaylistMapper;
import com.project.musicApp.repository.PlaylistRepository;

@Service
public class PlaylistService {
	
	@Autowired
	private PlaylistRepository playlistRepository;

	public ResponsePlaylistDto addPlaylist(RequestPlaylistDto data) {
		Playlist entity= PlaylistMapper.toEntity(data);
		Playlist create= playlistRepository.save(entity);
		return PlaylistMapper.toResponse(create);
	}
	
	

	public ResponsePlaylistDto getPlaylistById(int id) {
		
		return PlaylistMapper.toResponse(playlistRepository.findById(id).orElse(null));
		
	}
	public String updatePlaylist(int id, RequestPlaylistDto data) {
		Optional<Playlist> oldData = playlistRepository.findById(id);
		if (oldData.isEmpty()) {
			return "No Data Found for id: " + id;
		}
		Playlist newData = PlaylistMapper.toEntity(data);
		newData.setPlaylistId(id);
		playlistRepository.save(newData);
		return "Updated successfully: " + newData.getPlaylistName() + " (id=" + id + ")";
	}
	
	
	
	public String deletePlaylistById(int id) {
		
		if(playlistRepository.existsById(id)) {
			playlistRepository.deleteById(id);
			return "Deleted data from playlist---";
		}
		else {
		
		return "No data found";}
	}
	
	
	

}
