package com.example.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springboot.classes.Booking;
import com.example.springboot.classes.Taxi;
import com.example.springboot.classes.UserLogin;
import com.example.springboot.classes.UserRegistration;
import com.example.springboot.classes.UserType;
import com.example.springboot.repositories.UserRepository;
import com.example.springboot.services.UserService;

@Controller
public class HomeController {
	
	private final UserService userService;
	
	@Autowired
	public HomeController(UserService userService) {
	  this.userService = userService;	
	}

    @GetMapping("/")
    public String index(Model model) { 
    	 model.addAttribute("booking", new Booking());
        return "index";
    }
    
    @GetMapping("/sign-up")
    public String signUp(Model model) { 
    	 UserRegistration userRegistration = new UserRegistration();
    	 List<UserType> userTypes = userService.getUserTypes();
    	 userRegistration.setUserTypes(userTypes);
    	 model.addAttribute("userRegistration", userRegistration);
        return "sign-up";
    }
    
    @GetMapping("/login")
    public String login(Model model) { 
    	 UserLogin userLogin = new UserLogin();    	 
    	 model.addAttribute("userLogin", userLogin);
        return "login";
    }
}
