package com.music.playlist.controller;

import com.music.playlist.dto.PlayListRequest;
import com.music.playlist.model.PlayList;
import com.music.playlist.service.PlayListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/playlists")
public class PlayListController {

    private PlayListService playListService;

    public PlayListController(PlayListService playListService) {
        this.playListService = playListService;
    }

    @PostMapping()
    public ResponseEntity<PlayList> createPlayList(@RequestBody PlayListRequest playListRequest){
    	return ResponseEntity.status(HttpStatus.CREATED).body(playListService.createPlayList(playListRequest));
    }

    @GetMapping("/{playListId}")
    public ResponseEntity<PlayList> getPlayListById(@PathVariable Long playListId){
        return ResponseEntity.status(200).body(playListService.getPlayListByID(playListId));
    }

    @GetMapping
    public ResponseEntity<List<PlayList>> getAllPlayLists(){
        return ResponseEntity.status(200).body(playListService.getPlayLists());
    }

    @DeleteMapping("/{playListId}")
    public ResponseEntity<Void> deletePlayList(@PathVariable Long playListId){
    	playListService.deletePlayList(playListId);
        return ResponseEntity.status(204).build();
    }

}
