package com.shopstack.service.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopstack.dao.customer.CustomerDao;
import com.shopstack.entities.customer.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDaoImpl;
	
	public void saveCustomer(Customer customerId) {
		
		customerDaoImpl.saveCustomer(customerId);
		
	}

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerDaoImpl.getCustomers();
	}
	
	public void updateCustomer(Customer theCustomer) {
		customerDaoImpl.saveCustomer(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		// TODO Auto-generated method stub
		return customerDaoImpl.getCustomer(theId);
	}

	@Override
	public void deleteCustomer(int theId) {
		
		customerDaoImpl.deleteCustomer(theId);
		
	}

}
