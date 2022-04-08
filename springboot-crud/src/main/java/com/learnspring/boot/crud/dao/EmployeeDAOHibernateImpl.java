package com.learnspring.boot.crud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learnspring.boot.crud.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// define field for entitymanager
	private EntityManager entityManager;

	// setup constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {

		// get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// create query
		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);

		// execute query and get result list
		List<Employee> employees = query.getResultList();

		// return results
		return employees;
	}

	@Override
	public Employee findById(int theId) {

		Session currentSession = entityManager.unwrap(Session.class);
		Employee employee = currentSession.get(Employee.class, theId);

		return employee;
	}

	@Override
	public void save(Employee employee) {

		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);
	}

	@Override
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> query = currentSession.createQuery("delete from Employee where id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
		
	}

}
