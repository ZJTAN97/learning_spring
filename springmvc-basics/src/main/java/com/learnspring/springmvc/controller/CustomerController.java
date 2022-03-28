package com.learnspring.springmvc.controller;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learnspring.springmvc.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
    // to convert trim input strings
    // remove leading and trailing whitespace
    // resolve issue for our validation
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@RequestMapping("/form")
	public String showForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer/customer-form";
	}
	
	@RequestMapping("/process")
	public String processForm(
			@Valid @ModelAttribute("customer") Customer customer, 
			BindingResult bindingResult
		) {
		
		System.out.println("LastName: |" + customer.getLastName() + "|");
		System.out.println("Binding result: " + bindingResult);
		System.out.println("\n\n\n");
		
		if(bindingResult.hasErrors()) {
			return "customer/customer-form";
		} else {
			return "customer/customer-confirmation";
		}	
	}
}
