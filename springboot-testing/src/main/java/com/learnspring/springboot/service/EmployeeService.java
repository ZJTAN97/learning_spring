package com.learnspring.springboot.service;

import java.util.List;
import java.util.Optional;

import com.learnspring.springboot.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	List<Employee> getAllEmployees();

	Optional<Employee> getEmployeeById(Long id);

	Employee updateEmployee(Employee updatedEmployee);
	
	void deleteEmployee(Long id);

}
