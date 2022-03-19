package com.learnspring.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learnspring.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
				
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// query students -- all students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// query students: lastName="Kotlin"
			theStudents = session.createQuery("from Student s where s.lastName='Kotlin'").getResultList();
			
			
			// display the students
			for(Student tempStudent: theStudents) {
				System.out.println(tempStudent);
			}

			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done with transaction..");
			
		} finally {
			factory.close();
		}
		

	}

}
