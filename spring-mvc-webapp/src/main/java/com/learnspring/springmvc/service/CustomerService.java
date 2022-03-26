package com.learnspring.springmvc.service;

import java.util.List;

import com.learnspring.springmvc.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
	
}
