package com.learnspring.springdemo;

public class ExcitedFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is an exciting day!";
	}

}
