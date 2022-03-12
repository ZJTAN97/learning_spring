package com.learnspring.springdemo;

import org.springframework.stereotype.Component;

@Component
public class CalisthenicsCoach implements Coach {
	
	@Override
	public String getDailyWorkout() {
		return "Practice planche and front lever";
	}
	
}
