package com.example.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.springboot.classes.Booking;
import com.example.springboot.classes.Taxi;
import com.example.springboot.classes.User;
import com.example.springboot.services.BookingService;
import com.example.springboot.services.UserService;
import com.example.springboot.util.Constants;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/booking")
public class BookingController {
	
    private final BookingService bookingService;
    private final UserService userService;

    @Autowired
    public BookingController(BookingService bookingService,UserService userService) {
        this.bookingService = bookingService;
        this.userService= userService;
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
        redirectAttributes.addFlashAttribute("savedBooking", savedBooking);
        redirectAttributes.addFlashAttribute("addBookingSuccess", true);
        return redirectView;
    } 

}
