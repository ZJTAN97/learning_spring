package com.learnspring.hibernate.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learnspring.hibernate.demo.entity.Employee;

public class CreateEmployee {
	
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
				
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// create a student object
			System.out.println("Creating new student object...");
			Employee frontendDev = new Employee("Terry", "Terry", "front@end.com", "Front End Engineer");
			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving employee...");
			session.save(frontendDev);
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done with transaction..");
			
		} finally {
			factory.close();
		}
	}
}
