package com.project.musicApp.mapper;

import java.util.List;

import com.project.musicApp.dto.Artist.RequestArtistDto;
import com.project.musicApp.dto.playlist.RequestPlaylistDto;
import com.project.musicApp.dto.playlist.ResponsePlaylistDto;
import com.project.musicApp.dto.playlist.ResponsePlaylistDto.ResponsePlaylistDtoBuilder;
import com.project.musicApp.dto.track.ResponseTrackDto;
import com.project.musicApp.entity.Artist;
import com.project.musicApp.entity.Playlist;
import com.project.musicApp.entity.Tracks;

public class PlaylistMapper {
	
	public static Playlist toEntity(RequestPlaylistDto dto) {
		
		Playlist playlist=new Playlist();
		
		playlist.setPlaylistName(dto.getName());
		playlist.setDescription(dto.getDescription());
		
		return playlist;
	}
	
	public static ResponsePlaylistDto toResponse(Playlist playlist) {
		
		return ResponsePlaylistDto.builder()
				.id(playlist.getPlaylistId())
				.name(playlist.getPlaylistName())
				.description(playlist.getDescription()).build();
}
	

	public static List<ResponsePlaylistDto> toResponseList(List<Playlist> playlists) {
		return playlists.stream().map(PlaylistMapper::toResponse).toList();
	}
}