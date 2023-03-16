package com.example.springboot.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.example.springboot.classes.Booking;
import com.example.springboot.classes.Taxi;
import com.example.springboot.classes.User;
import com.example.springboot.classes.UserLogin;
import com.example.springboot.classes.UserRegistration;
import com.example.springboot.classes.UserType;
import com.example.springboot.services.TaxiService;
import com.example.springboot.services.UserService;
import com.example.springboot.util.Constants;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
	
	private final UserService userService;
	private final TaxiService taxiService;
	
	@Autowired
	public HomeController(UserService userService, TaxiService taxiService) {
	  this.userService = userService;	
	  this.taxiService = taxiService;
	}

    @GetMapping("/")
    public String index(Model model,HttpServletRequest request) {
	    String username = (String) request.getSession().getAttribute(Constants.SESSION_USERNAME);
	   	 if(username!=null) {
	   		 User loggedInUser = this.userService.getLoggedInUser(username);
	   		 model.addAttribute("loggedInUser",loggedInUser);
	   		 
	   	 }
	   	 model.addAttribute("booking",new Booking());
        return "index";
    }
    
    @GetMapping("/dashboard")
    public String dashboard(Model model,HttpServletRequest request) { 
	    String username = (String) request.getSession().getAttribute(Constants.SESSION_USERNAME);
	    Booking booking = new Booking();
	    List<Taxi> taxis = new ArrayList<>();
	    Taxi taxi = new Taxi();
	   
	   	 if(username!=null) {
	   		 User loggedInUser = this.userService.getLoggedInUser(username);
	   		 model.addAttribute("loggedInUser",loggedInUser);
	   		 
	   		 booking.setEmail(loggedInUser.getEmailAddress());
	   		 booking.setPhoneNo(loggedInUser.getPhoneNumber());
	   		 booking.setName(loggedInUser.getName());
	   		 
	   		taxis = this.taxiService.getTaxisByUser(loggedInUser);
	   		taxi.setUser(loggedInUser);
	   		 
	   	 }
	   	 model.addAttribute("booking",booking);
	   	 model.addAttribute("taxis",taxis);
	   	 model.addAttribute("taxi",taxi);
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
    public RedirectView logout(Model model,HttpServletRequest request) { 
    	final RedirectView redirectView;
    	 request.getSession().invalidate(); //destroy session
    	 redirectView = new RedirectView("/login", true); //redirect back to login
    	 return redirectView;
    }
}
