package com.project.musicApp.mapper;

import java.util.List;

import javax.sound.midi.Track;

import com.project.musicApp.dto.track.RequestTrackDto;
import com.project.musicApp.dto.track.ResponseTrackDto;
import com.project.musicApp.entity.Tracks;

public class TrackMapper {
	
	public static Tracks toEntity(RequestTrackDto dto) {
		  
		return Tracks.builder()
				.title(dto.getTitle())
				.albumName(dto.getAlbumName())
				.releaseDate(dto.getReleaseData())
				.duration(dto.getDuration())
				.genre(dto.getGenre())
				.description(dto.getDescription())
				.playcount(dto.getPlayCount())
				.fileUrl(dto.getFilUrl())
				.coverImage(dto.getCoverImage())
				.build();
	}

	public static ResponseTrackDto toResponse(Tracks tracks) {
		 return ResponseTrackDto.builder()
		 .id(tracks.getTrackId())
		 .title(tracks.getTitle())
		 .albumName(tracks.getAlbumName())
		 .releaseData(tracks.getReleaseDate())
		 .duration(tracks.getDuration())
		 .genre(tracks.getGenre())
		 .description(tracks.getDescription())
		 .playCount(tracks.getPlaycount())
		 .filUrl(tracks.getFileUrl())
		 .coverImage(tracks.getCoverImage()).build();
		 
		
	}
	public static List<ResponseTrackDto> toResponseList(List<Tracks> playlists) {
		return playlists.stream().map(TrackMapper::toResponse).toList();
	}
 
	
}
