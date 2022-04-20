package com.learnspring.springboot.repository;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.learnspring.springboot.model.Employee;

@DataJpaTest
public class EmployeeRepositoryTests {

	@Autowired
	private EmployeeRepository employeeRepository;

	private Employee employee, employee1, employee2, employee3;

	@BeforeEach
	public void setup() {
		employee = new Employee("Docker", "Kubernetes",
				"Docker@Kubernetes.com");
		employee1 = new Employee("Docker", "Kubernetes",
				"Docker@Kubernetes.com");
		employee2 = new Employee("React", "Spring", "Spring@React.com");
		employee3 = new Employee("Java", "TypeScript",
				"Java@TypeScript.com");
	}

	@Test
	public void givenEmployeeObject_whenSave_thenReturnSavedEmployee() {

		// when - action or the behavior to be tested
		Employee savedEmployee = employeeRepository.save(employee);

		// then - verify the output
		assertThat(savedEmployee).isNotNull();
		assertThat(savedEmployee.getId()).isGreaterThan(0);
	}

	@Test
	public void givenEmployeesList_whenFindAll_thenEmployeesList() {

		// given - precondition or setup
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
		employeeRepository.save(employee);

		// when - action or the behavior to be tested
		Employee employeeDB = employeeRepository
				.findByEmail(employee.getEmail()).get();

		// then - verify the output
		assertThat(employee).isEqualTo(employeeDB);
		assertThat(employeeDB).isNotNull();
	}

	@Test
	public void givenEmployeeObject_whenFindByFirstName_thenReturnEmployeeObject() {

		// given - precondition or setup
		employeeRepository.save(employee);

		// when - action or the behavior to be tested
		Employee employeeDB = employeeRepository
				.findByFirstName(employee.getFirstName()).get();
		// then - verify the output
		assertThat(employee).isEqualTo(employeeDB);
		assertThat(employeeDB).isNotNull();
	}

	@Test
	public void givenEmployeeObject_whenUpdateEmployee_thenReturnUpdatedEmployee() {

		employeeRepository.save(employee);

		Employee savedEmployee = employeeRepository
				.findById(employee.getId()).get();

		savedEmployee.setEmail("Kubernetes@Docker.com");
		savedEmployee.setFirstName("Kubernetes");
		savedEmployee.setLastName("Docker");
		Employee updatedEmployee = employeeRepository.save(savedEmployee);

		assertThat(updatedEmployee.getEmail())
				.isEqualTo("Kubernetes@Docker.com");
		assertThat(updatedEmployee.getFirstName()).isEqualTo("Kubernetes");
		assertThat(updatedEmployee.getLastName()).isEqualTo("Docker");
	}

	@Test
	public void givenEmployeeObject_whenDelete_thenRemoveEmployee() {

		employeeRepository.save(employee);

		employeeRepository.delete(employee);
		Optional<Employee> employeeOptional = employeeRepository
				.findById(employee.getId());

		assertThat(employeeOptional).isEmpty();
	}

	@Test
	public void givenEmployeeFirstNameAndLastName_whenFindByJPQL_thenReturnEmployeeObject() {

		employeeRepository.save(employee);
		String firstName = "Docker";
		String lastName = "Kubernetes";

		Employee savedEmployee = employeeRepository.findByJPQL(firstName,
				lastName);

		assertThat(savedEmployee).isNotNull();
	}

	@Test
	public void givenEmployeeFirstNameAndLastName_whenFindByJPQLNamedParams_thenReturnEmployeeObject() {

		employeeRepository.save(employee);
		String firstName = "Docker";
		String lastName = "Kubernetes";

		Employee savedEmployee = employeeRepository
				.findByJPQLNamedParams(firstName, lastName);

		assertThat(savedEmployee).isNotNull();
	}

	@Test
	public void givenEmployeeFirstNameAndLastName_whenFindByNativeSQL() {

		employeeRepository.save(employee);
		String firstName = "Docker";
		String lastName = "Kubernetes";

		Employee savedEmployee = employeeRepository
				.findByNativeSQL(firstName, lastName);

		assertThat(savedEmployee).isNotNull();
	}

	@Test
	public void givenEmployeeFirstNameAndLastName_whenFindByNativeSQLNamed() {

		employeeRepository.save(employee);
		String firstName = "Docker";
		String lastName = "Kubernetes";

		Employee savedEmployee = employeeRepository
				.findByNativeSQLNamedParams(firstName, lastName);

		assertThat(savedEmployee).isNotNull();
	}

}
