package com.learnspring.boot.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnspring.boot.crud.dao.EmployeeDAO;
import com.learnspring.boot.crud.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	private EmployeeDAO employeeDAO;

	@Autowired
	public void EmployeeRestController(EmployeeDAO theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
	}

	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

}
