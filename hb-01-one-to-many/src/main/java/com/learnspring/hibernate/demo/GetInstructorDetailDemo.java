package com.learnspring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learnspring.hibernate.demo.entity.Instructor;
import com.learnspring.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {	
			session.beginTransaction();
			
			int theId = 10;
			InstructorDetail selectedInstructorDetail = session.get(InstructorDetail.class, theId);
			
			System.out.println("Selected Instructor Detail: " + selectedInstructorDetail);			
			System.out.println(selectedInstructorDetail.getInstructor());
			
			session.getTransaction().commit();
			
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			// handle connection leak issue
			session.close();
			factory.close();
		}
		
	}

}
