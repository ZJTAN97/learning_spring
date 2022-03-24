package com.learnspring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learnspring.hibernate.demo.entity.Course;
import com.learnspring.hibernate.demo.entity.Instructor;
import com.learnspring.hibernate.demo.entity.InstructorDetail;
import com.learnspring.hibernate.demo.entity.Review;

public class GetCourseAndReviewsDemo {
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
			System.out.println("Selected Course: " + selectedCourse);
			
			// print the course reviews
			System.out.println(selectedCourse.getReviews());
			System.out.println("Done.");
			
		}
		finally {
			session.close();
		}
		
	}
}
