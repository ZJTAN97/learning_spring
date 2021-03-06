package com.learnspring.boot.crud.dao;

import java.util.List;

import com.learnspring.boot.crud.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee employee);
	
	public void deleteById(int id);
	
}
