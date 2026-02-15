package com.project.musicApp.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.musicApp.dto.track.RequestTrackDto;
import com.project.musicApp.dto.track.ResponseTrackDto;
import com.project.musicApp.entity.Tracks;
import com.project.musicApp.mapper.TrackMapper;
import com.project.musicApp.repository.TracksRepository;

@Service
public class TracksService {

	@Autowired
	private TracksRepository trackRepository;
	
	
	public List<ResponseTrackDto> getAllTracks() {
		List<Tracks> track= trackRepository.findAll();
		List<ResponseTrackDto> fullTracks= TrackMapper.toResponseList(track);
		return fullTracks;
	}


	public ResponseTrackDto addTracks(RequestTrackDto data) {
		Tracks entity= TrackMapper.toEntity(data);
		Tracks create= trackRepository.save(entity);
		return TrackMapper.toResponse(create);	
	}


	public ResponseTrackDto getTracksbyId(int id) {
		return TrackMapper.toResponse(trackRepository.findById(id).orElse(null));
		
	}


	public String deleteTrackById(int id) {
		if(trackRepository.existsById(id)) {
			trackRepository.deleteById(id);
			return "Track is deleted";
		}else {
			return "the track is not found";

		}
			}
	
	public String updateTrack(int id, RequestTrackDto data) {
		Tracks oldData = trackRepository.findById(id).orElse(null);
		if (!trackRepository.existsById(id)) {
			return "No Data Found for id: " + id;
		}
		
		oldData.setTrackId(id);
		oldData.setTitle(data.getTitle());
		oldData.setAlbumName(data.getAlbumName());
		oldData.setReleaseDate(data.getReleaseData());
		oldData.setDuration(data.getDuration());;
		oldData.setGenre(data.getGenre());
		oldData.setDescription(data.getDescription());
		oldData.setPlaycount(data.getPlayCount());
		oldData.setFileUrl(data.getFilUrl());
		oldData.setCoverImage(data.getCoverImage());
		
		trackRepository.save(oldData);
		return "Updated successfully";
	}

}
