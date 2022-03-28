package com.learnspring.springmvc.entity;

import java.util.LinkedHashMap;

public class Student {
	
	private String firstName;
	private String lastName;
	private String location;
	private String favouriteLanguage;
	private String[] operatingSystems;
	private LinkedHashMap<String, String> locationOptions;
	private LinkedHashMap<String, String> languageOptions;
	
	public Student() {
		// populate country options
		locationOptions = new LinkedHashMap<>();
		locationOptions.put("HG", "Hougang");
		locationOptions.put("SK", "Sengkang");
		locationOptions.put("PG", "Punggol");
		locationOptions.put("MB", "Marina Bay");
		
		
		// populate language options
		languageOptions = new LinkedHashMap<>();
		languageOptions.put("Java", "Java");
		languageOptions.put("JavaScript", "JavaScript");
		languageOptions.put("TypeScript", "TypeScript");
		languageOptions.put("Python", "Python");		
		
	}

	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LinkedHashMap<String, String> getLocationOptions() {
		return locationOptions;
	}


	public String getFavouriteLanguage() {
		return favouriteLanguage;
	}


	public void setFavouriteLanguage(String favouriteLanguage) {
		this.favouriteLanguage = favouriteLanguage;
	}
	
	public LinkedHashMap<String, String> getLanguageOptions() {
		return languageOptions;
	}


	public String[] getOperatingSystems() {
		return operatingSystems;
	}


	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}
}
