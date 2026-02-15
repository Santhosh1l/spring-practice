package com.hackerrank.whc.controller;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.whc.model.Coach;
import com.hackerrank.whc.repository.CoachRepository;

import jakarta.annotation.sql.DataSourceDefinition;

@RestController
@RequestMapping("/api/coach")
public class CoachController {

    final CoachRepository coachRepository;

    public CoachController(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }
    
    @PostMapping
    public ResponseEntity<Coach> createCoach(@RequestBody coachDto dto){
    	Coach c= new Coach();
    	c.setName(dto.getName());
    	
		return ResponseEntity.status(201).body(coachRepository.save(c));
    	
    }
    @GetMapping
    public ResponseEntity<List<Coach>> allCoach(){
    	
    	return ResponseEntity.status(200).body(coachRepository.findAll(Sort.by(Sort.Direction.ASC,"id")));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Coach> findById(@PathVariable("id") int id){
    	Coach c= coachRepository.findById(id).orElse(null);
    	if(c!=null) {
		return ResponseEntity.status(200).body(c);}
    	else {
    		return ResponseEntity.status(404).body(c);
    	}
    	
    }
    
    
    
    
}

class coachDto{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
