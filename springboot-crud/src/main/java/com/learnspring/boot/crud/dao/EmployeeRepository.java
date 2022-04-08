package com.learnspring.boot.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnspring.boot.crud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	// 
}
