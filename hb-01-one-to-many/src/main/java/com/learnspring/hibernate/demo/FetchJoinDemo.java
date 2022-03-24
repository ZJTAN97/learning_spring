package com.learnspring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.learnspring.hibernate.demo.entity.Course;
import com.learnspring.hibernate.demo.entity.Instructor;
import com.learnspring.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();

			int theId = 1;

			Query<Instructor> query = session.createQuery("select i from Instructor i "
												+ "JOIN FETCH i.courses "
												+ "where i.id=:theInstructorId", 
												Instructor.class);
			
			// set parameter on query
			query.setParameter("theInstructorId", theId);
			
			// execute query and get instructor
			Instructor selectedInstructor = query.getSingleResult();
			
			System.out.println("Instructor: " + selectedInstructor);
			
			

			session.getTransaction().commit();
			session.close();			
			System.out.println("Done.");
			
		}
		finally {
			
		}
		
	}
}
