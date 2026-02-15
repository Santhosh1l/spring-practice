package com.music.playlist.service.impl;

import com.music.playlist.controller.PlayListController;
import com.music.playlist.dto.PlayListRequest;
import com.music.playlist.model.PlayList;
import com.music.playlist.repository.PlayListRepository;
import com.music.playlist.service.PlayListService;

import org.hibernate.query.SortDirection;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PlayListServiceImpl implements PlayListService {

  //  private final PlayListController playListController;

    private PlayListRepository playListRepository;

    public PlayListServiceImpl(PlayListRepository playListRepository) {
        this.playListRepository = playListRepository;
       // this.playListController = playListController;
    }

    @Override
    public PlayList createPlayList(PlayListRequest playListRequest) {
        PlayList pl=new PlayList();
        pl.setName(playListRequest.name());
        pl.setTracksCount(playListRequest.tracksCount());
        return playListRepository.save(pl);
		
       
    }

    @Override
    public List<PlayList> getPlayLists() {
    	return playListRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public PlayList getPlayListByID(Long id) {
       return playListRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePlayList(Long id) {
    	if(playListRepository.existsById(id)) {
    		playListRepository.deleteById(id);
    	}

    }
}
