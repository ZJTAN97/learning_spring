package com.learnspring.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnspring.springboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	// custom query methods
	Optional<Employee> findByEmail(String email);

	Optional<Employee> findByFirstName(String firstName);

}
