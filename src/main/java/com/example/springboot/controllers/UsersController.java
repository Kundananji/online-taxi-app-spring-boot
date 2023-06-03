package com.example.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.springboot.classes.RegistrationResponse;
import com.example.springboot.classes.UserLogin;
import com.example.springboot.classes.UserLoginResponse;
import com.example.springboot.classes.UserRegistration;
import com.example.springboot.services.UserService;
import com.example.springboot.util.Constants;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class UsersController {
	
	private final UserService userService;
	
	@Autowired
	public UsersController(UserService userService) {
		this.userService = userService;
	}
	
    @PostMapping("/register")
    public RedirectView registerUser(@ModelAttribute("userRegistration") UserRegistration userRegistration, RedirectAttributes redirectAttributes,Model model) {
        final RedirectView redirectView = new RedirectView("/sign-up", true);
        RegistrationResponse response = userService.registerUser(userRegistration);
        redirectAttributes.addFlashAttribute("status", response.getStatus());
        redirectAttributes.addFlashAttribute("message", response.getMessage());
        
        return redirectView;
    }
    
    @PostMapping("/login")
    public RedirectView loginUser(@ModelAttribute("userLogin") UserLogin userLogin, RedirectAttributes redirectAttributes, HttpServletRequest request, Model model) {
        
    	final RedirectView redirectView;
       
        UserLoginResponse response = userService.login(userLogin);
        
        //set session on login
        if(response.getStatus().equals(Constants.SUCCESS)) {
        	redirectView = new RedirectView("/dashboard", true); //redirect to dashboard
        	request.getSession().setAttribute(Constants.SESSION_USERNAME,response.getUser().getEmailAddress());
        }
        else {
        	redirectView = new RedirectView("/login", true); //redirect back to login       	
        	
        }
        redirectAttributes.addFlashAttribute("status", response.getStatus());
        redirectAttributes.addFlashAttribute("message", response.getMessage());
              
        return redirectView;
    }

}
