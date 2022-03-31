package com.learnspring.hibernate.basics;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learnspring.hibernate.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
				
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentId = 1;
			
			// get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating student...");
			myStudent.setFirstName("JavaScript");
			
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
			// Bulk update example
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Student set email='full@stack.com'").executeUpdate();
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
		

	}

}
