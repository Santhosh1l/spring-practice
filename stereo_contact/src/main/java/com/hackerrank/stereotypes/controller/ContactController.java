package com.hackerrank.stereotypes.controller;

import com.hackerrank.stereotypes.model.Person;
import com.hackerrank.stereotypes.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")
public class ContactController {
	@Autowired
    ContactService contactService;
    
	@PostMapping("/save")
    public ResponseEntity<Person> save(@RequestBody Person person){
        Person saved = contactService.save(person);
        return ResponseEntity.status(201).body(saved);
    }

	@GetMapping("/retrieve/{id}")
    public ResponseEntity<Person> retrieve(@PathVariable("id") int id){
        Person person = contactService.retrieve(id);
        if(person!=null) {
        return  ResponseEntity.status(200).body(person);
    }
        return ResponseEntity.status(204).body(person);
}
}
