package com.jonarts.learnersacademy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jonarts.learnersacademy.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//Inject the session factory object
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Customer> getCustomers() {
		
		//Get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Create a query ...sort by last name
		
		Query <Customer> theQuery = currentSession.createQuery("from Customer order by lastName",
																Customer.class);
		
		// Execute query and get result list
		
		List <Customer> customers = theQuery.getResultList();
		
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		//Get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Save the customer
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomerById(int theId) {
		//Get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve / read form database using the primary key
		
		Customer theCustomer = currentSession.get(Customer.class,theId);
		
		return theCustomer;

	}

	@Override
	public void deleteCustomer(int theId) {
		
		//Get the current Hibernate session
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
		
		
	}

}
