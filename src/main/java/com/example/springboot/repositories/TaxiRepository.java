package com.example.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.classes.Taxi;

@Repository
public interface TaxiRepository extends JpaRepository<Taxi, Integer> {



}
