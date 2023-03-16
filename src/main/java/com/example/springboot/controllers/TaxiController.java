package com.example.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.springboot.classes.Taxi;
import com.example.springboot.classes.User;
import com.example.springboot.services.TaxiService;
import com.example.springboot.services.UserService;
import com.example.springboot.util.Constants;

import jakarta.servlet.http.HttpServletRequest;



@Controller
@RequestMapping("/taxi")
public class TaxiController {
	
	    private final TaxiService taxiService;
	    private final UserService userService;

	    @Autowired
	    public TaxiController(TaxiService taxiService,UserService userService) {
	        this.taxiService = taxiService;
	        this.userService = userService;
	    }

	    @GetMapping("/addTaxi")
	    public String addTaxiView(Model model) {
	        model.addAttribute("taxi", new Taxi());
	        return "add-taxi";
	    }

	    @PostMapping("/add")
	    public RedirectView addBook(@ModelAttribute("taxi") Taxi taxi, RedirectAttributes redirectAttributes,HttpServletRequest request) {
	    	String username = (String) request.getSession().getAttribute(Constants.SESSION_USERNAME);
	        final RedirectView redirectView = new RedirectView("/dashboard", true);
	        
	        if(username!=null) {
		   		 User loggedInUser = this.userService.getLoggedInUser(username);
		   		 taxi.setUser(loggedInUser);
	        }
	        
	      
	        Taxi savedTaxi = taxiService.addTaxi(taxi);
	        redirectAttributes.addFlashAttribute("addedTaxiReg", savedTaxi.getRegistrationNumber());
	        redirectAttributes.addFlashAttribute("addTaxiSuccess", true);
	        return redirectView;
	    } 
}
