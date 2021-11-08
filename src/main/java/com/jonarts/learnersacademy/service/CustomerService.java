package com.jonarts.learnersacademy.service;

import java.util.List;

import com.jonarts.learnersacademy.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomerById(int theId);

	public void deleteCustomer(int theId);
}
