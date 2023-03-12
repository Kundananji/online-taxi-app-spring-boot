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
import com.example.springboot.services.TaxiService;



@Controller
@RequestMapping("/taxi")
public class TaxiController {
	
	    private final TaxiService taxiService;

	    @Autowired
	    public TaxiController(TaxiService taxiService) {
	        this.taxiService = taxiService;
	    }

	    @GetMapping("/viewTaxis")
	    public String viewTaxis(Model model) {
	        model.addAttribute("taxis", taxiService.getTaxis());
	        return "view-taxis";
	    }
	    
	    @GetMapping("/addTaxi")
	    public String addTaxiView(Model model) {
	        model.addAttribute("taxi", new Taxi());
	        return "add-taxi";
	    }

	    @PostMapping("/addTaxi")
	    public RedirectView addBook(@ModelAttribute("taxi") Taxi taxi, RedirectAttributes redirectAttributes) {
	        final RedirectView redirectView = new RedirectView("/taxi/addTaxi", true);
	        Taxi savedTaxi = taxiService.addTaxi(taxi);
	        redirectAttributes.addFlashAttribute("savedTaxi", savedTaxi);
	        redirectAttributes.addFlashAttribute("addTaxiSuccess", true);
	        return redirectView;
	    } 
}
