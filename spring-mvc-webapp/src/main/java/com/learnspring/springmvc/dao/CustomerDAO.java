package com.learnspring.springmvc.dao;

import java.util.List;

import com.learnspring.springmvc.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();
	
}
