package com.adrianbarczuk.springdemo.dao;

import java.util.List;

import com.adrianbarczuk.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void addCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);

	public List<Customer> searchCustomers(String searchName);

}
