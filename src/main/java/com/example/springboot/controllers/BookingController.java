package com.example.springboot.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.springboot.classes.Booking;
import com.example.springboot.classes.Taxi;
import com.example.springboot.classes.TaxiSearch;
import com.example.springboot.classes.User;
import com.example.springboot.services.BookingService;
import com.example.springboot.services.TaxiService;
import com.example.springboot.services.UserService;
import com.example.springboot.util.Constants;
import com.example.springboot.util.DistanceCalculator;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/booking")
public class BookingController {
	
    private final BookingService bookingService;
    private final UserService userService;
    private final TaxiService taxiService;

    @Autowired
    public BookingController(BookingService bookingService,UserService userService,TaxiService taxiService) {
        this.bookingService = bookingService;
        this.userService= userService;
        this.taxiService = taxiService;
    }
	
    @PostMapping("/add")
    public RedirectView addBook(@ModelAttribute("booking") Booking booking, RedirectAttributes redirectAttributes,HttpServletRequest request) {
    	String username = (String) request.getSession().getAttribute(Constants.SESSION_USERNAME);
        final RedirectView redirectView;  
        //redirect to dashboard if user is logged in
        if(username!=null) {
	   		 User loggedInUser = this.userService.getLoggedInUser(username);
	   		 redirectView = new RedirectView("/dashboard", true);
	   		 
        }
        else {
        	redirectView = new RedirectView("/", true);
        }
        Booking savedBooking = bookingService.addBooking(booking);
        String[] userLocation = savedBooking.getPickUp().split(",");
        
        
        //get coordinates from saved booking
        
        //get all taxis stored in database, and calculate how far away they are
        List<Taxi> availableTaxis = this.taxiService.getTaxis();
        
        ArrayList<TaxiSearch> search = new ArrayList<>()
        
        //loop through, computing the distance for each
        for(int i = 0; i<availableTaxis.size(); i++) {
        	Taxi taxi = availableTaxis.get(i);
        	String[] taxtLocation = taxi.getLocation().split(",");
        	
        	Double distanceAway = DistanceCalculator.calculateDistance(Double.parseDouble(userLocation[0]), Double.parseDouble(userLocation[1]), Double.parseDouble(taxtLocation[0]), Double.parseDouble(taxtLocation[1]));
        
        	TaxiSearch searchTaxi = new TaxiSearch();
        	searchTaxi.setBooking(savedBooking);
        	searchTaxi.setDistance(distanceAway);
        	searchTaxi.setDriverName(taxi.getDriverName());
        	searchTaxi.setLocation(taxi.getLocation());
        	searchTaxi.setName(taxi.getName());
        	searchTaxi.setRegistrationNumber(taxi.getRegistrationNumber());
        
        
        }
        
        
        
        
        redirectAttributes.addFlashAttribute("savedBooking", savedBooking);
        redirectAttributes.addFlashAttribute("addBookingSuccess", true);
        return redirectView;
    } 

}
