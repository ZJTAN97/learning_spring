package com.learnspring.springboot.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learnspring.springboot.model.Employee;
import com.learnspring.springboot.service.EmployeeService;

@WebMvcTest
public class EmployeeControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeService employeeService;

	@Autowired
	private ObjectMapper objectMapper;

	@DisplayName("Testing createEmployee REST API")
	@Test
	public void givenEmployeeObject_whenCreateEmployee_thenReturnsSavedEmployee()
			throws Exception {

		// given - precondition or setup
		Employee employee = new Employee("Docker", "Kubernetes",
				"Docker@Kubernetes.com");

		given(employeeService.saveEmployee(any(Employee.class)))
				.willAnswer((invocation) -> invocation.getArgument(0));

		// when - action or behavior that we going to test
		ResultActions response = mockMvc.perform(post("/api/employees")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(employee)));

		// then - verify the result or output using assert statements
		response.andDo(print()) // to print response
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.firstName",
						is(employee.getFirstName())))
				.andExpect(
						jsonPath("$.lastName", is(employee.getLastName())))
				.andExpect(jsonPath("$.email", is(employee.getEmail())));
	}

	@DisplayName("Testing getAllEmployees REST API")
	@Test
	public void givenListOfEmployees_whenGetAllEmployees_thenReturnEmployeesList()
			throws Exception {

		// given - precondition or setup
		List<Employee> listOfEmployees = new ArrayList<>();
		listOfEmployees.add(new Employee("Docker", "Kubernetes",
				"Docker@Kubernetes.com"));
		listOfEmployees.add(
				new Employee("TypeScript", "Java", "TypeScript@Java.com"));
		given(employeeService.getAllEmployees())
				.willReturn(listOfEmployees);

		// when - action or behavior to be tested
		ResultActions response = mockMvc.perform(get("/api/employees"));

		// then - verify the result
		response.andExpect(status().isOk()).andDo(print()).andExpect(
				jsonPath("$.size()", is(listOfEmployees.size())));
	}

	@DisplayName("Testing getEmployeesById REST API")
	@Test
	public void givenEmployeeId_whenGetEmployeeId_thenReturnEmployeeObject()
			throws Exception {

		// given
		Long employeeId = 1L;
		Employee employee = new Employee("Docker", "Kubernetes",
				"Docker@Kubernetes.com");
		given(employeeService.getEmployeeById(employeeId))
				.willReturn(Optional.of(employee));

		// when
		ResultActions response = mockMvc
				.perform(get("/api/employees/{id}", employeeId));

		// then
		response.andExpect(status().isOk()).andDo(print())
				.andExpect(jsonPath("$.firstName",
						is(employee.getFirstName())))
				.andExpect(
						jsonPath("$.lastName", is(employee.getLastName())))
				.andExpect(jsonPath("$.email", is(employee.getEmail())));

	}

	@DisplayName("Testing getEmployeesById 404 REST API")
	@Test
	public void givenInvalidEmployeeId_whenGetEmployeeId_thenReturnEmpty()
			throws Exception {

		// given
		Long employeeId = 1L;
		given(employeeService.getEmployeeById(employeeId))
				.willReturn(Optional.empty());

		// when
		ResultActions response = mockMvc
				.perform(get("/api/employees/{id}", employeeId));

		// then
		response.andExpect(status().isNotFound()).andDo(print());

	}

}
