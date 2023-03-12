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
import com.example.springboot.services.BookingService;

@Controller
@RequestMapping("/booking")
public class BookingController {
	
    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
	
    @PostMapping("/add")
    public RedirectView addBook(@ModelAttribute("booking") Booking booking, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/", true);
        Booking savedBooking = bookingService.addBooking(booking);
        redirectAttributes.addFlashAttribute("savedBooking", savedBooking);
        redirectAttributes.addFlashAttribute("addBookingSuccess", true);
        return redirectView;
    } 

}
