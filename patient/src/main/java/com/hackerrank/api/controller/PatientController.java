package com.hackerrank.api.controller;

import com.hackerrank.api.exception.BadRequestException;
import com.hackerrank.api.exception.ElementNotFoundException;
import com.hackerrank.api.model.Patient;
import com.hackerrank.api.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
  private final PatientService patientService;

  @Autowired
  public PatientController(PatientService patientService) {
    this.patientService = patientService;
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<List<Patient>> getAllPatient() {
	  List<Patient> all=patientService.getAllPatient();
    return ResponseEntity.status(200).body(all);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
	  
	 	  if(patient.getId()==null) {
	 		 Patient p1= patientService.createNewPatient(patient);
			  return ResponseEntity.status(201).body(p1);
	 		
	  }
	  else {
		  return ResponseEntity.status(400).build();
		 
	  }
	  
    
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Patient getPatientById(@PathVariable("id") Long id) {

	   if(id < 1) {
		   throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	   }
	   
	   return patientService.getPatientById(id);
 }}