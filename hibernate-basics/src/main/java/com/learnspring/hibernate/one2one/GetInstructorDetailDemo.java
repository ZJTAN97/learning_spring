package com.learnspring.hibernate.one2one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learnspring.hibernate.entity.Instructor;
import com.learnspring.hibernate.entity.InstructorDetail;

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
			
			int theId = 2;
			Instructor selectedInstructor = session.get(Instructor.class, theId);
			InstructorDetail selectedInstructorDetail = session.get(InstructorDetail.class, theId);
			
			System.out.println("Selected Instructor: " + selectedInstructor);
			System.out.println("Selected Instructor Detail: " + selectedInstructorDetail);			
			System.out.println(selectedInstructorDetail.getInstructor());
						
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
