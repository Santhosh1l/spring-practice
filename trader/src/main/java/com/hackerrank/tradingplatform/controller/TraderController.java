package com.hackerrank.tradingplatform.controller;

import com.hackerrank.tradingplatform.dto.AddMoneyTraderDTO;
import com.hackerrank.tradingplatform.dto.TraderDTO;
import com.hackerrank.tradingplatform.dto.UpdateTraderDTO;
import com.hackerrank.tradingplatform.model.Trader;
import com.hackerrank.tradingplatform.service.TraderService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

import java.util.Comparator;

@RestController
@RequestMapping(value = "/trading/traders")
public class TraderController {
    @Autowired
    private TraderService traderService;

    //register
    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerTrader(@RequestBody @Valid Trader trader) {
       traderService.registerTrader(trader);
     
    }

    //get by email
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Trader> getTraderByEmail(@RequestParam("email") String email) {
        Trader t1= traderService.getTraderByEmail(email);
        if(t1!=null) {
        	return ResponseEntity.status(200).body(t1);
        }
        else {
        	return ResponseEntity.status(404).body(t1);
        }
    }

    //get all
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<TraderDTO>> getAllTraders() {
    	
    	List<TraderDTO> res= traderService.getAllTraders();
return res.isEmpty()
            ? ResponseEntity.noContent().build()
            : ResponseEntity.ok(res);
}
		 
    

    //update by email
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Trader> updateTrader(@RequestBody @Valid UpdateTraderDTO trader) {
        Trader updateTrader= traderService.updateTrader(trader);
        if(updateTrader !=null) {
        	return ResponseEntity.status(200).body(updateTrader);
        }
        else {
        	return ResponseEntity.status(404).body(updateTrader);
        }
    }

    //add money
    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public ResponseEntity<Trader> addMoney(@RequestBody @Valid AddMoneyTraderDTO trader) {
    
    	Trader updateTrader= traderService.addMoney(trader);
        if(updateTrader !=null) {
        	return ResponseEntity.status(200).body(updateTrader);
        }
        else {
        	return ResponseEntity.status(404).body(updateTrader);
        }
    }
}
