package com.example.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springboot.classes.Booking;
import com.example.springboot.classes.Taxi;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) { 
    	 model.addAttribute("booking", new Booking());
        return "index";
    }
}
