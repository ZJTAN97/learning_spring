package com.learnspring.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/name")
public class NameController {
	
	@RequestMapping("/form")
	public String showForm() {
		return "name/name-form";
	}
	
	@RequestMapping("/process")
	public String processForm() {
		return "name/name-confirmation";
	}
	
}
