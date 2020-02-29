package com.shopstack.dao.business;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;

import com.shopstack.entities.business.*;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopstack.entities.businessuser.BusinessUser;

import static javax.persistence.criteria.JoinType.INNER;


/**
 * @author oluwatobi
 *
 */
@Repository
@Transactional
public class BusinessDaoImpl implements BusinessDao {
	
	private Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public void save(Business theBusiness) {
		
		Session currentSession = getCurrentSession();
		
		if(theBusiness != null)
			currentSession.save(theBusiness);
		
	}

	public Session getCurrentSession() {
		Session currentSession = null;
		
		try {
			currentSession = sessionFactory.getCurrentSession();
		}
		catch(Exception exe) {
			
			logger.log(Level.SEVERE, "Exception thrown while getting current session");
		}
		
		return currentSession;
	}


	
	
	@Override
	public Business findByEmail(String bizEmail) {
		
		Business result = null;
		
		Session currentSession = getCurrentSession();
		
		try {
			
			
			@SuppressWarnings("rawtypes")
			Query query = currentSession.createQuery("from Business b where b.bizEmail = :email");
			
			query.setParameter("email", bizEmail);
			
			result = (Business) query.getResultList().get(0);			
			
		}catch(RuntimeException exe) {
			
			logger.info("Exception thrown while retrieve business from the database");
			
			exe.printStackTrace();
			result = null;
			
		}
	
		
		return result;
		
	}

	@Override
	public Business findById(int businessId) {
		
		Session currentSession = getCurrentSession();
		Business existingBusiness;
		
		try {
			existingBusiness = currentSession.get(Business.class, businessId);
			
			Hibernate.initialize(existingBusiness.getBizCategory());
			Hibernate.initialize(existingBusiness.getBizService());
			Hibernate.initialize(existingBusiness.getCreator());
		}
		catch(HibernateException he) {
			logger.info("Hibernate exception");
			existingBusiness = null;
		}
		
		return existingBusiness;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BusinessCategory> findAll() {
		
		List<BusinessCategory> result = null;
		
		Session currentSession = getCurrentSession();
		
		try {
			@SuppressWarnings("rawtypes")
			Query query = currentSession.createQuery("from BusinessCategory");
			
			result =  query.getResultList();
		}
		catch(RuntimeException ex) {
			
			logger.info("Error fetching Business Categories");
			result = null;
		}
		
		return result;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BusinessServiceType> findAllServiceTypes() {
		
		List<BusinessServiceType> result = null;
		
		Session currentSession = getCurrentSession();
		
		try {
			@SuppressWarnings("rawtypes")
			Query query = currentSession.createQuery("from BusinessServiceType");
			
			result =  query.getResultList();
		}
		catch(RuntimeException ex) {
			
			logger.info("Error fetching Business Service Types");
			result = null;
		}
		
		return result;
	}

	@Override
	public BusinessOutlet 	findOutletById(int outletId) {
			
		Session currentSession = getCurrentSession();
		
		return currentSession.get(BusinessOutlet.class, outletId);
		
	}


	@Override
	public void save(BusinessOutlet newBusinessOutlet) {
		
			Session currentSession = getCurrentSession();
		
		if(newBusinessOutlet != null) 
			currentSession.save(newBusinessOutlet);

	}


	@Override
	public BusinessCategory findBusinessCategoryByName(String ObjectId) {
		
		BusinessCategory result = null;
		
		Session currentSession = getCurrentSession();
		
		try {
			
			
			@SuppressWarnings("rawtypes")
			Query<BusinessCategory> query = currentSession.createQuery("from BusinessCategory b where b.bizCategoryName = : name");
			
			query.setParameter("name", ObjectId);
			
			result = query.getResultList().get(0);
			
		}catch(RuntimeException exe) {
			
			logger.info("Exception thrown while retrieve business category from the database");
			
			exe.printStackTrace();
			result = null;
			
		}
	
		
		return result;
	}

	@Override
	public BusinessServiceType findBusinessServiceTypeByName(String ObjectId) {
		
		BusinessServiceType result = null;
		
		Session currentSession = getCurrentSession();
		
		try {
			
			
			@SuppressWarnings("rawtypes")
			Query<BusinessServiceType> query = currentSession.createQuery("from BusinessServiceType b where b.bizServiceName = : name");
			
			query.setParameter("name", ObjectId);
			
			result =  query.getResultList().get(0);
			
		}catch(RuntimeException exe) {
			
			logger.info("Exception thrown while retrieve business category from the database");
			
			exe.printStackTrace();
			result = null;
			
		}
	
		
		return result;
	}

}
