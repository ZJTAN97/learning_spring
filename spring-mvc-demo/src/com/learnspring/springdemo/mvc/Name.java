package com.learnspring.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/name")
public class Name {
	
	// need a controller method to show the initial HTML form
	@RequestMapping("/nameForm")
	public String showForm() {
		return "name-form";
	}
	
	// need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	
	// new controller method to read form data
	// and add data to the model
	@RequestMapping("/processFormTwo")
	public String readFormData(HttpServletRequest request, Model model) {
		
		// read the request parameter from HTML form
		String theName = request.getParameter("studentName");
		
		// convert the data to all caps
		theName = theName.toUpperCase();
		
		// create message
		String result = "Yo! " + theName;
		
		// add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	
	@RequestMapping("/processFormThree")
	public String readFormDataTwo(
			@RequestParam("studentName") String theName, 
			Model model) 
	{
		
		// convert the data to all caps
		theName = theName.toUpperCase();
		
		// create message
		String result = "Yo version 3! " + theName;
		
		// add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
}
