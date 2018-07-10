package com.adrianbarczuk.springdemo.dao;

import java.util.List;

import com.adrianbarczuk.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void addCustomer(Customer customer);

}
