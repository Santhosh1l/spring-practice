package com.project.musicApp.mapper;

import java.util.List;

import com.project.musicApp.dto.Artist.RequestArtistDto;
import com.project.musicApp.dto.Artist.ResponseArtistDto;
import com.project.musicApp.entity.Artist;

public class ArtistMapper {

	public static Artist toEntity(RequestArtistDto dto) {
		Artist artist=new Artist();
		artist.setName(dto.getName());
		artist.setBio(dto.getBio());
		artist.setFormedYear(dto.getFormedYear());
		artist.setGenre(dto.getGenere());
		artist.setImage(dto.getImage());
		artist.setSocialLink(dto.getSocialLink());
		artist.setOrigin(dto.getOrigin());
		return artist;
	}
	
	public static ResponseArtistDto toResponse(Artist artist) {
		ResponseArtistDto response= new ResponseArtistDto();
		response.setId(artist.getId());
		response.setName(artist.getName());
		response.setImage(artist.getImage());
		response.setBio(artist.getBio());
		response.setFormedYear(artist.getFormedYear());
		response.setGenere(artist.getGenre());
		response.setImage(artist.getImage());
		response.setOrigin(artist.getOrigin());
		response.setSocialLink(artist.getSocialLink());
		
		return response;
	}
	
	public static List<ResponseArtistDto> toResponseList(List<Artist> playlists) {
		return playlists.stream().map(ArtistMapper::toResponse).toList();
	}
 
}
