package com.learnspring.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		// read spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach calisthenicsCoach = context.getBean("calisthenicsCoach", Coach.class);
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(calisthenicsCoach.getDailyWorkout());
		
		// call daily fortune
		System.out.println(theCoach.getDailyFortune());
		System.out.println(calisthenicsCoach.getDailyFortune());
		
		// close the context
		context.close();

	}

}
