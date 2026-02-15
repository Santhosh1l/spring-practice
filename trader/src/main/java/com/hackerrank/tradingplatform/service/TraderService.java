package com.hackerrank.tradingplatform.service;

import com.hackerrank.tradingplatform.dto.AddMoneyTraderDTO;
import com.hackerrank.tradingplatform.dto.TraderDTO;
import com.hackerrank.tradingplatform.dto.UpdateTraderDTO;
import com.hackerrank.tradingplatform.model.Trader;
import com.hackerrank.tradingplatform.repository.TraderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import static java.util.stream.Collectors.toList;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class TraderService {
    @Autowired
    private TraderRepository traderRepository;

    public void registerTrader(Trader trader) {

    	if(traderRepository.existsByEmail(trader.getEmail())) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    	 traderRepository.save(trader);
    }

    public Trader getTraderById(Long id) {
        return traderRepository.findById(id).get();
    }

    public Trader getTraderByEmail(String email) {
        return traderRepository.findByEmail(email).orElse(null);
    }

    public List<TraderDTO> getAllTraders() {
    	List<TraderDTO> result= traderRepository.findAll()
                .stream().sorted(Comparator.comparing(Trader::getId))
                .map(TraderDTO::new)
                .collect(toList());

        return result;
    }

    public Trader updateTrader(UpdateTraderDTO trader) {
        Trader existingTrader = traderRepository.findByEmail(trader.getEmail()).orElse(null);
        if(existingTrader==null) {
        	return null;
        }
        else {
        	existingTrader.setName(trader.getName());
        	return traderRepository.save(existingTrader);
        }
    }

    public Trader addMoney(AddMoneyTraderDTO trader) {
    	
        Trader existingTrader = traderRepository.findByEmail(trader.getEmail()).orElse(null);
        if(existingTrader==null) {
        return null;
        }
        else {
        existingTrader.setBalance(existingTrader.getBalance() + trader.getAmount());
        
      return  traderRepository.save(existingTrader);
        }
    }
}
