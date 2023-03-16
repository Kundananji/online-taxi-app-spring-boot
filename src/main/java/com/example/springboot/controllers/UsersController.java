package com.example.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

@Controller
@RequestMapping("/users")
public class UsersController {
	
	private final UserService userService;
	
	@Autowired
	public UsersController(UserService userService) {
		this.userService = userService;
	}
	
    @PostMapping("/register")
    public RedirectView addBook(@ModelAttribute("userRegistration") UserRegistration userRegistration, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/sign-up", true);
        RegistrationResponse response = userService.registerUser(userRegistration);
        redirectAttributes.addFlashAttribute("response", response);      
        redirectAttributes.addFlashAttribute("savedRegistration", response.getStatus() == Constants.SUCCESS);
        return redirectView;
    }
    
    @PostMapping("/login")
    public RedirectView addBook(@ModelAttribute("userLogin") UserLogin userLogin, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/login", true);
        UserLoginResponse response = userService.login(userLogin);
        redirectAttributes.addFlashAttribute("response", response);      
        return redirectView;
    }

}
