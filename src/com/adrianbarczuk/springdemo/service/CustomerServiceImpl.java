package com.adrianbarczuk.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adrianbarczuk.springdemo.dao.CustomerDAO;
import com.adrianbarczuk.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		List<Customer> customers = customerDAO.getCustomers();
		
		return customers;
	}

	@Override
	@Transactional
	public void addCustomer(Customer customer) {
		
		customerDAO.addCustomer(customer);
		
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		
		Customer customer = customerDAO.getCustomer(id);
		
		return customer;
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		
		customerDAO.deleteCustomer(id);
	}

}
