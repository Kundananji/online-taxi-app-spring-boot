package com.example.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.classes.RegistrationResponse;
import com.example.springboot.classes.User;
import com.example.springboot.classes.UserLogin;
import com.example.springboot.classes.UserLoginResponse;
import com.example.springboot.classes.UserRegistration;
import com.example.springboot.classes.UserType;
import com.example.springboot.repositories.TaxiRepository;
import com.example.springboot.repositories.UserRepository;
import com.example.springboot.repositories.UserTypeRepository;
import com.example.springboot.util.Constants;

@Service
public class UserService {
	public final UserRepository userRepository;
	public final UserTypeRepository userTypeRepository;
	
	@Autowired
	public UserService(UserRepository userRepository, UserTypeRepository userTypeRepository) {
		this.userRepository = userRepository;
		this.userTypeRepository = userTypeRepository;
	}

	public RegistrationResponse registerUser(UserRegistration userRegistration) {
		 User user = new User();
		 user.setEmailAddress(userRegistration.getEmailAddress());
		 user.setName(userRegistration.getName());
		 user.setPhoneNumber(userRegistration.getPhoneNumber());
		 user.setPassword(userRegistration.getPassword());
		 user.setUserType(userRegistration.getSelectedUserType());		 
		 
		User createdUser = this.userRepository.save(user);
		
		RegistrationResponse response = new RegistrationResponse();
		
		if(createdUser!=null) {
		
			response.setStatus(Constants.SUCCESS);
			response.setTitle("Successfully Registered!");
			response.setMessage("Your account has been successfully registered. You can now login.");
			response.setUser(createdUser);
		}
		else {
			
			response.setStatus(Constants.FAILURE);
			response.setTitle("Registration failed");
			response.setMessage("Sorry, something went wrong. Try again later");
			response.setUser(createdUser);
		}
	 
		return response;
	}

	public List<UserType> getUserTypes() {
		return this.userTypeRepository.findAll();
	}

	public UserLoginResponse login(UserLogin userLogin) {
		User user= this.userRepository.findByEmailAddressOrPhoneNumber(userLogin.getUsername(),userLogin.getPassword());
		UserLoginResponse response = new UserLoginResponse();
		
		response.setStatus(Constants.SUCCESS);
		response.setTitle("Successfully logged in");
		response.setMessage("You have been successfully logged in!");
	
		
		if(user == null) {
			response.setStatus(Constants.FAILURE);
			response.setTitle("Failed to Login");
			response.setMessage("Sorry, failed to login. Check your credentials");
		}
		
		if(user != null && !user.getPassword().equals(userLogin.getPassword())) {
			response.setStatus(Constants.FAILURE);
			response.setTitle("Failed to Login");
			response.setMessage("Sorry, failed to login. Check your credentials");
		}
	
			
		
		return response;
		 
	}

}
