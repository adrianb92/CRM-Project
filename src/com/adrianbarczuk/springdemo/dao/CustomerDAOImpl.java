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
	public List<Customer> getCustomers() {
		
		//get hibernate session
		Session session = sessionFactory.getCurrentSession(); 
		
		//create query and get customers sorted by last name
		Query<Customer> query = 
				session.createQuery("from Customer order by lastName", Customer.class);
		
		List<Customer> customers= query.getResultList();
		
		//return results
		return customers;
	}

	@Override
	public void addCustomer(Customer customer) {
		
		//get hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//add new customer
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int id) {

		//get hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//get customer
		Customer customer = session.get(Customer.class, id);
		
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		
		//get hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//delete customer
		Customer customer = session.get(Customer.class, id);
		
		session.delete(customer);
	}
}