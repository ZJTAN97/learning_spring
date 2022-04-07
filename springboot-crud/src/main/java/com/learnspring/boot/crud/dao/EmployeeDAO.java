package com.learnspring.boot.crud.dao;

import java.util.List;

import com.learnspring.boot.crud.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
}
