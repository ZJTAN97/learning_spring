package com.learnspring.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learnspring.springmvc.entity.User;


@Controller
@RequestMapping("/signup")
public class SignUpController {
	
	@ModelAttribute("user")
	public User setNewUser() {
		return new User();
	}
	
	@GetMapping("/form")
	public String showForm() {
		return "signup/signup-form";
	}
	
	
	@PostMapping("/saveSignUpForm")
	public String saveUser(@ModelAttribute("user") User newUser, Model theModel) {
		
		// implement business logic to save user details into a database
        System.out.println("FirstName : " + newUser.getFirstName());
        System.out.println("LastName : " + newUser.getLastName());
        System.out.println("Username : " + newUser.getUserName());
        System.out.println("Password : " + newUser.getPassword());
        System.out.println("Email : " + newUser.getEmail());
        
        theModel.addAttribute("message", "User Sign up successfully.");
        theModel.addAttribute("additional", "just testing the model attribute");
        
        return "signup/signup-success";
	}
	
}
