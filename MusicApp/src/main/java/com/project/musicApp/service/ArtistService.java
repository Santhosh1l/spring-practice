package com.project.musicApp.service;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.musicApp.dto.Artist.RequestArtistDto;
import com.project.musicApp.dto.Artist.ResponseArtistDto;
import com.project.musicApp.entity.Artist;
import com.project.musicApp.mapper.ArtistMapper;
import com.project.musicApp.repository.ArtistRepository;

@Service
public class ArtistService {

	@Autowired
	private ArtistRepository artistRepository;
	
	public  ResponseArtistDto addArtist(RequestArtistDto data) {
		Artist entity= ArtistMapper.toEntity(data);
		Artist create=artistRepository.save(entity);
		return ArtistMapper.toResponse(create);
	}
	
	public List<ResponseArtistDto> getAllArtist(){
		List<Artist> all = artistRepository.findAll();
		List<ResponseArtistDto> responseList = ArtistMapper.toResponseList(all);
		return responseList;
	}
	
	public ResponseArtistDto getArtistById(int id) {
		Optional<Artist> data= artistRepository.findById(id);
		if(data!=null) {
			Artist getData=artistRepository.save(data.get());
			return ArtistMapper.toResponse(getData);
		}
		return null;
	}
	
	public String updateArtist(int id, RequestArtistDto data) {
		Optional<Artist> oldData = artistRepository.findById(id);
		if (oldData.isEmpty()) {
			return "No Data Found for id: " + id;
		}
		Artist newData = ArtistMapper.toEntity(data);
		newData.setId(id);
		artistRepository.save(newData);
		return "Updated successfully: " + newData.getName() + " (id=" + id + ")";
	}
	
	public String deleteArtist(int id) {
		 if (artistRepository.existsById(id)) {
		        artistRepository.deleteById(id);
		        return " deleted successfully.";
		    } else {
		        return " not found.";
		    }

		
	}

}
