package com.example.springboot.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.classes.Taxi;
import com.example.springboot.classes.TaxiSearch;
import com.example.springboot.classes.User;
import com.example.springboot.repositories.TaxiRepository;
import com.example.springboot.repositories.TaxiSearchRepository;

@Service
public class TaxiService {
	
	public final TaxiRepository taxiRepository;
	public final TaxiSearchRepository taxiSearchRepository;
	
	@Autowired
	public TaxiService(TaxiRepository taxiRepository,TaxiSearchRepository taxiSearchRepository) {
		this.taxiRepository = taxiRepository;
		this.taxiSearchRepository = taxiSearchRepository;
	}
	public List<Taxi> getTaxis(){
		return this.taxiRepository.findAll();
	}
    
	public Taxi addTaxi(Taxi taxi) {
		return this.taxiRepository.save(taxi);
    }
	
	public List<Taxi> getTaxisByUser(User loggedInUser) {		
		return this.taxiRepository.findByUser(loggedInUser);
	}
	public void deleteSearch(User loggedInUser) {
		this.taxiSearchRepository.deleteAll();
		
	}
	public void addSearch(ArrayList<TaxiSearch> search) {
		this.taxiSearchRepository.saveAll(search);
		
	}
}
