package com.learnspring.hibernate.one2many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learnspring.hibernate.entity.Course;
import com.learnspring.hibernate.entity.Instructor;
import com.learnspring.hibernate.entity.InstructorDetail;
import com.learnspring.hibernate.entity.Review;


public class GetInstructorCoursesDemo {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();

			int theId = 1;
			Instructor selectedInstructor = session.get(Instructor.class, theId);
			
			System.out.println("Instructor: " + selectedInstructor);
			
			System.out.println("Courses: " + selectedInstructor.getCourses());

			session.getTransaction().commit();
			
			System.out.println("Done.");
			
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			session.close();
		}
		
	}
}
