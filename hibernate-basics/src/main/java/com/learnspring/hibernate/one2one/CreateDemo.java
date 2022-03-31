package com.learnspring.hibernate.one2one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learnspring.hibernate.entity.Instructor;
import com.learnspring.hibernate.entity.InstructorDetail;

public class CreateDemo {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			Instructor newInstructor = new Instructor(
					"Docker", "Kubernetes,", "Docker@Kubernetes.com");
			InstructorDetail newInstructorDetail = new InstructorDetail(
					"https://askmaesenior.com", "calisthenics");
			
			newInstructor.setInstructorDetail(newInstructorDetail);
			
			session.beginTransaction();
			
			// NOTE: will also save detail object
			// because of CascasdeType.ALL
			System.out.println("Saving instructor: " + newInstructor);
			session.save(newInstructor);
			
			session.getTransaction().commit();
			System.out.println("Added new instructor to database.");
			
		} finally {
			// handle connection leak issue
			session.close();
			factory.close();
		}
	}

}
