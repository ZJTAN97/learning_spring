package com.learnspring.hibernate.basics;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learnspring.hibernate.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
				
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// create 3 student objects
			System.out.println("Creating 3 new students object...");
			Student tempStudent1 = new Student("React", "Spring", "React@Spring.com");
			Student tempStudent2 = new Student("Java", "TypeScript", "Java@TypeScript.com");
			Student tempStudent3 = new Student("Python", "Kotlin", "Python@Kotlin.com");
			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving 3 new students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done with transaction..");
			
		} finally {
			factory.close();
		}
	}

}
