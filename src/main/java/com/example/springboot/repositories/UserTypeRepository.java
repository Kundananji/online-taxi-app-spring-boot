package com.example.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.classes.UserType;

public interface UserTypeRepository extends JpaRepository<UserType, Integer> {

}
