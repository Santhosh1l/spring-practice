package com.hackerrank.whc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.whc.model.Coach;
import com.hackerrank.whc.model.Customer;
import com.hackerrank.whc.repository.CoachRepository;
import com.hackerrank.whc.repository.CustomerRepository;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
    private CustomerRepository customerRepository;
	@Autowired
	private CoachRepository coachRepository;
	
	@PostMapping
	public ResponseEntity<Customer> createCustomer(@RequestBody customerdto dto){
		Customer c1=new Customer();
		c1.setHeight(dto.getHeight());
		c1.setWeight(dto.getWeight());
		Coach c= coachRepository.findById(dto.getCoach_id()).orElse(null);
		c1.setCoach(c);
		return ResponseEntity.status(201).body(customerRepository.save(c1));
		
	}
	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomer(){
		return ResponseEntity.status(200).body(customerRepository.findAll(Sort.by(Sort.Direction.ASC,"id")));
	}
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable ("id") int id){
		
		Customer c= new Customer();
		c= customerRepository.findById(id).orElse(null);
		if(c!=null) {
			return ResponseEntity.status(200).body(c);
		}
		else {
			return ResponseEntity.status(404).body(c);
		}
		
	}

    
}
class customerdto {
	int height;
	int weight;
	int coach_id;
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getCoach_id() {
		return coach_id;
	}
	public void setCoach_id(int coach_id) {
		this.coach_id = coach_id;
	}

}
