package com.learnspring.springmvc.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learnspring.springmvc.model.HelloWorld;

@Controller
public class HelloWorldController {

	@RequestMapping("/helloworld")
	public String handler(Model model) {
		HelloWorld helloWorld = new HelloWorld();
		helloWorld.setMessage("Hello World example Spring MVC web app!");
		helloWorld.setDateTime(LocalDateTime.now().toString());
		model.addAttribute("helloWorld", helloWorld);
		return "helloworld";
	}
	
}
