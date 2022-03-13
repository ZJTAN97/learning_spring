package com.learnspring.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CalisthenicsCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	public CalisthenicsCoach() {
		System.out.println(">> CalisthenicsCoach: Constructor called.");
	}
	
//	@Autowired
//	public CalisthenicsCoach(FortuneService theFortuneService) {
//		fortuneService = theFortuneService;
//	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice planche and front lever";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
}
