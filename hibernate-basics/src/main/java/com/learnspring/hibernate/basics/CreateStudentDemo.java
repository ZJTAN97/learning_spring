package com.learnspring.hibernate.basics;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learnspring.hibernate.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
				
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// create a student object
			System.out.println("Creating new student object...");
			Student tempStudent = new Student("test1", "test1", "test1@test1.com");
			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving student...");
			session.save(tempStudent);
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done with transaction..");
			
		} finally {
			factory.close();
		}
		

	}

}
