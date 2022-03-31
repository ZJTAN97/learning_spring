package com.learnspring.hibernate.one2one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learnspring.hibernate.entity.Instructor;
import com.learnspring.hibernate.entity.InstructorDetail;

public class DeleteDemo {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();

			int theId = 1;
			Instructor instructorToRemove = session.get(Instructor.class, theId);
			
			System.out.println("Found instructor: " + instructorToRemove);
			if(instructorToRemove != null) {
				System.out.println("Deleting: " + instructorToRemove);
				
				// Note: will ALSO delete associated "details" object
				// because of CascadeType.ALL
				session.delete(instructorToRemove);
			}
			// commit delete
			session.getTransaction().commit();
			System.out.println("Delete completed.");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			// handle connection leak issue
			session.close();
			factory.close();
		}		
	}
}
