package com.example.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.classes.User;
import com.example.springboot.classes.UserLoginResponse;

public interface UserRepository extends JpaRepository<User, Long>  {

	User findByEmailAddressOrPhoneNumberAndPassword(String username,String phoneNumber, String password);

	User findByEmailAddressOrPhoneNumber(String username, String password);



}
