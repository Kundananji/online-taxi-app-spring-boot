package com.example.springboot.services;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.classes.Taxi;
import com.example.springboot.classes.User;
import com.example.springboot.repositories.TaxiRepository;

@Service
public class TaxiService {
	
	public final TaxiRepository taxiRepository;
	
	@Autowired
	public TaxiService(TaxiRepository taxiRepository) {
		this.taxiRepository = taxiRepository;
	}
	public Collection<Taxi> getTaxis(){
		return this.taxiRepository.findAll();
	}
    
	public Taxi addTaxi(Taxi taxi) {
		return this.taxiRepository.save(taxi);
    }
	
	public List<Taxi> getTaxisByUser(User loggedInUser) {		
		return this.taxiRepository.findByUser(loggedInUser);
	}
}
