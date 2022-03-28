package com.learnspring.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learnspring.springmvc.entity.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("/form")
	public String showForm(Model model) {
		model.addAttribute("student", new Student());
		return "student/student-form";
	}
	
	@RequestMapping("/process")
	public String processForm(@ModelAttribute("student") Student student ) {
		System.out.println("FirstName: " + student.getFirstName());
		System.out.println("LastName: " + student.getLastName());
		return "student/student-confirmation";
	}
		
}
