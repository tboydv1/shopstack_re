package com.shopstack.service.customer;

import java.util.List;

import com.shopstack.entities.customer.Customer;

public interface CustomerService {
	 
	public void saveCustomer(Customer customerId);

	public List<Customer> getCustomers();

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

}
