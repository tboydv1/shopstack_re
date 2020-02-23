package com.shopstack.service.customer;

import java.util.List;

import com.shopstack.entities.customer.Customer;

public interface CustomerService {
	 
	public void addCustomer(Customer customerId);

	public List<Customer> getCustomers();

}
