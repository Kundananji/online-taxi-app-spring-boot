package com.example.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springboot.classes.Booking;
import com.example.springboot.classes.Taxi;
import com.example.springboot.classes.User;
import com.example.springboot.classes.UserLogin;
import com.example.springboot.classes.UserRegistration;
import com.example.springboot.classes.UserType;
import com.example.springboot.repositories.UserRepository;
import com.example.springboot.services.UserService;
import com.example.springboot.util.Constants;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
	
	private final UserService userService;
	
	@Autowired
	public HomeController(UserService userService) {
	  this.userService = userService;	
	}

    @GetMapping("/")
    public String index(Model model,HttpServletRequest request) {
	    String username = (String) request.getSession().getAttribute(Constants.SESSION_USERNAME);
	   	 if(username!=null) {
	   		 User loggedInUser = this.userService.getLoggedInUser(username);
	   		 model.addAttribute("loggedInUser",loggedInUser);
	   		 
	   	 }
        return "index";
    }
    
    @GetMapping("/dashboard")
    public String dashboard(Model model,HttpServletRequest request) { 
	    String username = (String) request.getSession().getAttribute(Constants.SESSION_USERNAME);
	   	 if(username!=null) {
	   		 User loggedInUser = this.userService.getLoggedInUser(username);
	   		 model.addAttribute("loggedInUser",loggedInUser);
	   		 
	   	 }
        return "dashboard";
    }
    
    @GetMapping("/sign-up")
    public String signUp(Model model,HttpServletRequest request) { 
    	 UserRegistration userRegistration = new UserRegistration();
    	 
    	 List<UserType> userTypes = userService.getUserTypes();
    	 userRegistration.setUserTypes(userTypes);
    	 model.addAttribute("userRegistration", userRegistration);
    	 
    	 String username = (String) request.getSession().getAttribute(Constants.SESSION_USERNAME);
    	 if(username!=null) {
    		 User loggedInUser = this.userService.getLoggedInUser(username);
    		 model.addAttribute("loggedInUser",loggedInUser);
    		 
    	 }
    	 
        return "sign-up";
    }
    
    @GetMapping("/login")
    public String login(Model model,HttpServletRequest request) { 
    	 UserLogin userLogin = new UserLogin();    	 
    	 model.addAttribute("userLogin", userLogin);
 	    String username = (String) request.getSession().getAttribute(Constants.SESSION_USERNAME);
	   	 if(username!=null) {
	   		 User loggedInUser = this.userService.getLoggedInUser(username);
	   		 model.addAttribute("loggedInUser",loggedInUser);
	   		 
	   	 }
        return "login";
    }
    
    @GetMapping("/logout")
    public String logout(Model model,HttpServletRequest request) { 
    	 request.getSession().invalidate(); //destroy session
         return "index";
    }
}
