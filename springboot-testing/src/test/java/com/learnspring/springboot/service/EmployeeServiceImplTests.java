package com.learnspring.springboot.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

import com.learnspring.springboot.exception.ResourceNotFoundException;
import com.learnspring.springboot.model.Employee;
import com.learnspring.springboot.repository.EmployeeRepository;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTests {

	@Mock
	private EmployeeRepository employeeRepository;

	@InjectMocks
	private EmployeeServiceImpl employeeService;

	private Employee employee;
	private Employee employee1;

	@BeforeEach
	public void setup() {
		employee = new Employee(1L, "Docker", "Kubernetes",
				"Docker@Kubernetes.com");
		employee1 = new Employee(1L, "Spring", "React",
				"Spring@React.com");
	}

	@DisplayName("JUnit test for saveEmployee method")
	@Test
	public void givenEmployeeObject_whenSaveEmployee_thenReturnEmployeeObject() {

		given(employeeRepository.findByEmail(employee.getEmail()))
				.willReturn(Optional.empty());

		given(employeeRepository.save(employee)).willReturn(employee);

		Employee savedEmployee = employeeService.saveEmployee(employee);

		assertThat(savedEmployee).isNotNull();

	}

	@DisplayName("JUnit test for saveEmployee method which throws Exception")
	@Test
	public void givenExistingEmail_whenSaveEmployee_thenThrowsException() {

		given(employeeRepository.findByEmail(employee.getEmail()))
				.willReturn(Optional.of(employee));

		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			employeeService.saveEmployee(employee);
		});

		verify(employeeRepository, never()).save(any(Employee.class));

	}

	@DisplayName("JUnit test for getAllEmployees method (Positive scenario)")
	@Test
	public void givenEmployeesList_whenGetAllEmployees_thenReturnEmployeesList() {

		given(employeeRepository.findAll())
				.willReturn(List.of(employee, employee1));

		List<Employee> employeeList = employeeService.getAllEmployees();

		assertThat(employeeList.size()).isEqualTo(2);
		assertThat(employeeList).isNotNull();
	}

	@DisplayName("JUnit test for getAllEmployees method (Negative scenario)")
	@Test
	public void givenEmptyEmployeesList_whenGetAllEmployees_thenReturnEmptyEmployeesList() {

		given(employeeRepository.findAll())
				.willReturn(Collections.emptyList());

		List<Employee> employeeList = employeeService.getAllEmployees();

		assertThat(employeeList).isEmpty();
		assertThat(employeeList.size()).isEqualTo(0);
	}

	@DisplayName("JUnit test for getEmployeeById method")
	@Test
	public void givenEmployeeId_whenGetEmployeeById_thenReturnEmployee() {

		given(employeeRepository.findById(1L))
				.willReturn(Optional.of(employee));

		Employee retrievedEmployee = employeeService
				.getEmployeeById(employee.getId()).get();

		assertThat(retrievedEmployee.getFirstName()).isEqualTo("Docker");
		assertThat(retrievedEmployee).isNotNull();
	}

	@DisplayName("JUnit test for updateEmployee method")
	@Test
	public void givenEmployeeObject_whenUpdateEmployee_thenReturnUpdatedEmployee() {

		given(employeeRepository.save(employee)).willReturn(employee);
		employee.setEmail("Java@TypeScript.com");
		employee.setFirstName("Java");
		employee.setLastName("TypeScript");

		Employee updatedEmployee = employeeService
				.updateEmployee(employee);

		assertThat(updatedEmployee.getEmail())
				.isEqualTo("Java@TypeScript.com");
		assertThat(updatedEmployee.getFirstName()).isEqualTo("Java");
		assertThat(updatedEmployee.getLastName()).isEqualTo("TypeScript");
	}

	@DisplayName("JUnit test for deleteEmployee method")
	@Test
	public void givenEmployeeId_whenDeleteEmployee_thenReturnVoid() {

		Long employeeId = 1L;

		willDoNothing().given(employeeRepository).deleteById(employeeId);

		employeeService.deleteEmployee(employeeId);

		verify(employeeRepository, times(1)).deleteById(employeeId);

	}

}
