package com.learnspring.hibernate.one2many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learnspring.hibernate.entity.Course;
import com.learnspring.hibernate.entity.Instructor;
import com.learnspring.hibernate.entity.InstructorDetail;
import com.learnspring.hibernate.entity.Review;

public class CreateCoursesDemo {
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
		
			
			Course newCourse1 = new Course("Spring Boot");
			Course newCourse2 = new Course("React");
			
			selectedInstructor.add(newCourse1);
			selectedInstructor.add(newCourse2);
			
		
			session.save(newCourse1);
			session.save(newCourse2);

			session.getTransaction().commit();
			
			System.out.println("Courses added to Instructor.");
			
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			session.close();
		}
		
	}
}
