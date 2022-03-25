package com.learnspring.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learnspring.springmvc.dao.CustomerDAO;
import com.learnspring.springmvc.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// inject customer DAO
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get customers from DAO
		List<Customer> theCustomers = customerDAO.getCustomers();
		
		// add customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		
		return "list-customers";
	}
	
}
