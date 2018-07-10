package com.adrianbarczuk.springdemo.service;

import java.util.List;

import com.adrianbarczuk.springdemo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void addCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);

	public List<Customer> searchCustomers(String searchName);

}
