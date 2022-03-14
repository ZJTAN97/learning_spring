package com.learnspring.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.learnspring.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	// defined bean for our excited fortune service
	@Bean
	public FortuneService excitedFortuneService() {
		return new ExcitedFortuneService();
	}
	
	
	// define bean for swim coach and inject dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(excitedFortuneService());
	}
	
}
