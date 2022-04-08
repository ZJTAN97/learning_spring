package com.learnspring.boot.crud.service;

import java.util.List;

import com.learnspring.boot.crud.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee employee);
	
	public void deleteById(int id);
	
}
