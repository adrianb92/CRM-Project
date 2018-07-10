package com.adrianbarczuk.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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

	@Override
	public List<Customer> searchCustomers(String searchName) {
		
		//get hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> query;
		
		//search customers by name
		if(searchName!=null && searchName.trim().length()>0) {
			query = session.createQuery("from Customer where lower(firstName) like :name or lower(lastName) like :name", Customer.class);
			query.setParameter("name", "%" + searchName.toLowerCase() + "%");
		} else {
			query = session.createQuery("from Customer", Customer.class);
		}
		
		//get results and return them
		List<Customer> customers = query.getResultList();
		return customers;
	}
}