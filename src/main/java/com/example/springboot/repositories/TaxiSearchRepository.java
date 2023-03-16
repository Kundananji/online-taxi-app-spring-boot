package com.example.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.classes.TaxiSearch;
import com.example.springboot.classes.User;

@Repository
public interface TaxiSearchRepository extends JpaRepository<TaxiSearch, Long> {

	void deleteByUser(User loggedInUser);


}
