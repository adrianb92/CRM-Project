package com.adrianbarczuk.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adrianbarczuk.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		//get hibernate session
		Session session = sessionFactory.getCurrentSession(); 
		
		//create query and get customers
		Query<Customer> query = 
				session.createQuery("from Customer", Customer.class);
		
		List<Customer> customers= query.getResultList();
		
		//return results
		return customers;
	}
}
