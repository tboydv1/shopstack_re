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
 * @author adefunmi
 *
 */
	
@Repository
public class CustomerDaoImpl implements CustomerDao {
	

	@Autowired
	private SessionFactory sessionFactory;
	
	private Logger logger = Logger.getLogger(CustomerDao.class);
	

	@Transactional
	@Override
	public void addCustomer(Customer customerId) {
	
	
		Session currentSession = sessionFactory.getCurrentSession();
		logger.info("Saving Customer to database " + customerId.toString());
		
		currentSession.save(customerId);
		 
		
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
	

	

}
