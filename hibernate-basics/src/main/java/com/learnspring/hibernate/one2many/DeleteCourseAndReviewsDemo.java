package com.learnspring.hibernate.one2many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learnspring.hibernate.entity.Course;
import com.learnspring.hibernate.entity.Instructor;
import com.learnspring.hibernate.entity.InstructorDetail;
import com.learnspring.hibernate.entity.Review;


public class DeleteCourseAndReviewsDemo {
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
			
			// get the course
			int theId = 10;
			Course selectedCourse = session.get(Course.class, theId);
			
			// print the course
			System.out.println("Selected Course to delete: " + selectedCourse);
			
			
			session.delete(selectedCourse);
			session.getTransaction().commit();
			
			System.out.println("Done deleting.");
			
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			session.close();
		}
		
	}
}
