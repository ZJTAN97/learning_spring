package com.learnspring.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	// create an array of strings
	private String[] data = {
			"Random service message 1",
			"Random service message 2",
			"Random service message 3",
	};
	
	// Create a random number generator
	private Random myRandom = new Random();

	@Override
	public String getFortune() {
		
		int index = myRandom.nextInt(data.length);
		
		String theFortune = data[index];
		
		return theFortune;
	}

}
