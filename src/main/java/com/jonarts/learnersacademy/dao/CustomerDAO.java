package com.jonarts.learnersacademy.dao;

import java.util.List;

import com.jonarts.learnersacademy.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomerById(int theId);

	public void deleteCustomer(int theId);   
}
