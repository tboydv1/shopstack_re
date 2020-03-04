package com.shopstack.dao.customer;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.shopstack.entities.customer.Customer;

/**
 * @author adeola
 *
 */
	
@Repository
public class CustomerDaoImpl implements CustomerDao {
	

	@Autowired
	private SessionFactory sessionFactory;
	
	private Logger logger = Logger.getLogger(CustomerDao.class);
	

	@Transactional
	@Override
	public void saveCustomer(Customer customerId) {
	
	
		Session currentSession = sessionFactory.getCurrentSession();
		logger.info("Saving Customer to database " + customerId.toString());
		
		currentSession.saveOrUpdate(customerId);
		 
		
		}


	@Transactional
	@Override
	public Customer findById(int customerId) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Customer.class, customerId);
	}


	@Override
	@Transactional
	public List<Customer> getCustomers() {
		//get currentSession
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer",
																Customer.class);
		
		//get a result list from the query execution
		List<Customer> customers = theQuery.getResultList();
		
		//return result
		
		return customers;
	}


	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		//get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				//retrieve from database using the primary key
				Customer theCustomer = currentSession.get(Customer.class, theId);
				
		return theCustomer;
	}


	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Customer customer = currentSession.byId(Customer.class).load(theId);
		
		currentSession.delete(customer);
		
		
	}
	

	

}
