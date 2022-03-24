package com.learnspring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learnspring.hibernate.demo.entity.Course;
import com.learnspring.hibernate.demo.entity.Instructor;
import com.learnspring.hibernate.demo.entity.InstructorDetail;
import com.learnspring.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {
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
			
			// create a course
			Course newCourse = new Course("React and Spring");
			
			// add some reviews
			newCourse.addReview(new Review("Great course, learnt full stack development"));
			newCourse.addReview(new Review("Enterprise ready now"));
			newCourse.addReview(new Review("Learnt frontend, backend and dev ops"));
			
			// save course + reviews (leveraging cascade all)
			session.save(newCourse);

			session.getTransaction().commit();
			
			System.out.println("Done.");
			
		}
		finally {
			
		}
		
	}
}
