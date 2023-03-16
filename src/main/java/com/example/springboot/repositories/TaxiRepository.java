package com.example.springboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.classes.Taxi;
import com.example.springboot.classes.User;

@Repository
public interface TaxiRepository extends JpaRepository<Taxi, Integer> {

	List<Taxi> findByUser(User loggedInUser);



}
