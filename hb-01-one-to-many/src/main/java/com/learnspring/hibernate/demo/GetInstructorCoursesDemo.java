package com.learnspring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learnspring.hibernate.demo.entity.Course;
import com.learnspring.hibernate.demo.entity.Instructor;
import com.learnspring.hibernate.demo.entity.InstructorDetail;

public class GetInstructorCoursesDemo {
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
			Instructor selectedInstructor = session.get(Instructor.class, theId);
			
			System.out.println("Instructor: " + selectedInstructor);
			
			System.out.println("Courses: " + selectedInstructor.getCourses());

			session.getTransaction().commit();
			
			System.out.println("Done.");
			
		}
		finally {
			
		}
		
	}
}
