package com.learnspring.springdemo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	private String emailAddress;
	private String team;

	// create no-arg constructor
	public CricketCoach() {
		System.out.println("CricketCoach: inside no-arg constructor");
	}
	
	// setter and getter methods
	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: inside setter method -- setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: inside setter method -- setTeam");
		this.team = team;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setter method -- setFortuneService");
		this.fortuneService = fortuneService;
	}
	

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice fast bowling for 15minutes";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
