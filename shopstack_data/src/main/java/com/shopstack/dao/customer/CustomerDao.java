package com.shopstack.dao.customer;

import java.util.List;

import com.shopstack.entities.customer.Customer;

public interface CustomerDao {
	
	public void addCustomer(Customer customerId);
	
	public Customer findById(int customerId);

	public List<Customer> getCustomers();
}
