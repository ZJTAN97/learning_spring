package com.learnspring.boot.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.learnspring.boot.crud.dao.EmployeeRepository;
import com.learnspring.boot.crud.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	// constructor injection
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {

		Optional<Employee> result = employeeRepository.findById(id);

		Employee theEmployee = null;

		if (result.isPresent()) {
			theEmployee = result.get();
		} else {
			throw new RuntimeException("Did not find employee id - " + id);
		}

		return theEmployee;
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}

}
