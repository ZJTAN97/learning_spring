package com.learnspring.springdemo;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {
	
	@PostConstruct
	public void doMyStartupFortuneService() {
		System.out.println("PostConstruct: for my happy fortune service");
	}
	
	

	@Override
	public String getFortune() {
		return "Today is your lucky day!";
	}

}
