package com.shopstack.dao.business;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.hibernate.Hibernate;
import org.jboss.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.shopstack.context.config.DataContextConfig;
import com.shopstack.dao.businessuser.BusinessUserDao;
import com.shopstack.entities.business.Business;
import com.shopstack.entities.business.BusinessCategory;
import com.shopstack.entities.business.BusinessOutlet;
import com.shopstack.entities.business.BusinessServiceType;
import com.shopstack.entities.businessuser.BusinessUser;


/**
 * @author oluwatobi
 *
 */
@Sql(scripts= {"classpath:/db/shopstack-create-db.sql", "classpath:/db/business-category-insert.sql", "classpath:/db/insert-users.sql","classpath:/db/insert-business.sql"})
@ContextConfiguration(classes= DataContextConfig.class)	
@RunWith(SpringRunner.class)
public class BusinessDaoImplTest {
	
	Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	private BusinessUserDao businessUserDao;
	
	
	@Autowired
	private BusinessDao businessDaoImpl;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	
	@Test
	public void classesInitializedTest() {
		assertNotNull(businessDaoImpl);
	}
	
	@Test
	public void getBusinessServiceTest() {
		
		List<BusinessServiceType> savedList = businessDaoImpl.findAllServiceTypes(); 
		assertNotNull(savedList);
		
	}
	

	@Test
	public void getBusinessCategories() {
		
		List<BusinessCategory> savedList = businessDaoImpl.findAllCategories(); 
		assertNotNull(savedList);
//		savedList.forEach(System.out::println);

	}
	
	@Test
	public void saveNewBusinessTest() {
		
		BusinessUser businessUser = businessUserDao.loadUserByEmail("tosho@mail.com");
		assertNotNull(businessUser);
		
		List<BusinessCategory> categoryList = businessDaoImpl.findAllCategories(); 
		assertNotNull(categoryList);
		
		List<BusinessServiceType> servicesList = businessDaoImpl.findAllServiceTypes(); 
		assertNotNull(servicesList);
		
		Business newBusiness = new Business("Shopify", "shopify@mybusiness.com", 
				categoryList.get(2), servicesList.get(1), businessUser);
		
		businessDaoImpl.save(newBusiness);
		
		int businessId = newBusiness.getBizId();
		Business savedBusiness = businessDaoImpl.findById(businessId);
				
		assertNotNull(savedBusiness);
		assertNotNull(savedBusiness.getBizCategory());
		assertNotNull(savedBusiness.getBizService());
		assertNotNull(savedBusiness.getCreator());

	}
	
	@Test
	public void saveNewBusinessOutletTest() {
		Business newBusiness = businessDaoImpl.findById(1);
		BusinessOutlet newBusinessOutlet = new BusinessOutlet("adebola ventures NIG.", "312,herbert macaulay road", newBusiness);
		
		 businessDaoImpl.save(newBusinessOutlet);
		 
		 
		int outletId = newBusinessOutlet.getOutletId();
		logger.info("Business outlet id is "+outletId);
		
		BusinessOutlet existBusinessOutlet = businessDaoImpl.findOutletById(outletId);
		assertNotNull(existBusinessOutlet);
			
			
	}
	
	
	
	

}
