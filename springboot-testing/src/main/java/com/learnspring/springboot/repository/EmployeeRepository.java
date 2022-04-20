package com.learnspring.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.learnspring.springboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	// custom query methods
	Optional<Employee> findByEmail(String email);

	Optional<Employee> findByFirstName(String firstName);

	// defining custom query using JPQL with index params
	@Query("select e from Employee e where e.firstName = ?1 and e.lastName = ?2")
	Employee findByJPQL(String firstName, String lastName);

	// defining custom query using JPQL with named params
	@Query("select e from Employee e where e.firstName =:firstName and e.lastName =:lastName")
	Employee findByJPQLNamedParams(@Param("firstName") String firstName,
			@Param("lastName") String lastName);

	@Query(value = "select * from employees e where e.first_name =?1 and e.last_name =?2", nativeQuery = true)
	Employee findByNativeSQL(String firstName, String lastName);

	@Query(value = "select * from employees e where e.first_name =:firstName and e.last_name =:lastName", nativeQuery = true)
	Employee findByNativeSQLNamedParams(
			@Param("firstName") String firstName,
			@Param("lastName") String lastName);

}
