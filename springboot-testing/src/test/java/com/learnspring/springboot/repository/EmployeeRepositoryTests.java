package com.learnspring.springboot.repository;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.learnspring.springboot.model.Employee;

@DataJpaTest
public class EmployeeRepositoryTests {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	public void givenEmployeeObject_whenSave_thenReturnSavedEmployee() {

		// given - precondition or setup
		Employee employee = new Employee("Docker", "Kubernetes",
				"Docker@Kubernetes.com");

		// when - action or the behavior to be tested
		Employee savedEmployee = employeeRepository.save(employee);

		// then - verify the output
		assertThat(savedEmployee).isNotNull();
		assertThat(savedEmployee.getId()).isGreaterThan(0);
	}

	@Test
	public void givenEmployeesList_whenFindAll_thenEmployeesList() {

		// given - precondition or setup
		Employee employee1 = new Employee("Docker", "Kubernetes",
				"Docker@Kubernetes.com");
		Employee employee2 = new Employee("React", "Spring",
				"Spring@React.com");
		Employee employee3 = new Employee("Java", "TypeScript",
				"Java@TypeScript.com");

		employeeRepository.save(employee1);
		employeeRepository.save(employee2);
		employeeRepository.save(employee3);

		// when - action or the behavior to be tested
		List<Employee> employeeList = employeeRepository.findAll();

		// then - verify the output
		assertThat(employeeList).isNotNull();
		assertThat(employeeList.size()).isEqualTo(3);
	}

	@Test
	public void givenEmployeeObject_whenFindById_thenReturnEmployeeObject() {

		// given - precondition or setup
		Employee employee = new Employee("Docker", "Kubernetes",
				"Docker@Kubernetes.com");
		employeeRepository.save(employee);

		// when - action or the behavior to be tested
		Employee employeeDB = employeeRepository.findById(employee.getId())
				.get();

		// then - verify the output
		assertThat(employee).isEqualTo(employeeDB);
		assertThat(employeeDB).isNotNull();
	}

	@Test
	public void givenEmployeeObject_whenFindByEmail_thenReturnEmployeeObject() {

		// given - precondition or setup
		Employee employee = new Employee("Docker", "Kubernetes",
				"Docker@Kubernetes.com");
		employeeRepository.save(employee);

		// when - action or the behavior to be tested
		Employee employeeDB = employeeRepository.findByEmail(employee.getEmail()).get();

		// then - verify the output
		assertThat(employee).isEqualTo(employeeDB);
		assertThat(employeeDB).isNotNull();
	}

}
