package com.learnspring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learnspring.hibernate.demo.entity.Instructor;
import com.learnspring.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			Instructor newInstructor = new Instructor("Docker", "Kubernetes", "Docker@kubernetes.com");
			InstructorDetail newInstructorDetail = new InstructorDetail("https://askmaesenior.com", "calisthenics");
			
			newInstructor.setInstructorDetail(newInstructorDetail);
			
			session.beginTransaction();
			
			// NOTE: will also save detail object
			// because of CascadeType.ALL
			System.out.println("Saving instructor: " + newInstructor);
			session.save(newInstructor);
			
			session.getTransaction().commit();
			
		}
		finally {
			
		}
		
	}

}
