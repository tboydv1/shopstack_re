package com.shopstack.dao.business;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import java.util.logging.Logger;
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

@Sql(scripts= {"classpath:/db/insert-into-business-and-user-data.sql"})
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
		
		logger.info("Fetching saved business service reference data");
		
		List<BusinessServiceType> savedList = businessDaoImpl.findAllServiceTypes(); 
		assertNotNull(savedList);
		
	}
	

	@Test
	public void getBusinessCategories() {
		
		logger.info("Fetching saved business category reference data");

		List<BusinessCategory> savedList = businessDaoImpl.findAll(); 
		assertNotNull(savedList);


	}
	
	@Test
	public void saveNewBusinessTest() {
		
		logger.info("Fetching saved business user");
		
		BusinessUser businessUser = businessUserDao.loadUserByEmail("tosho@mail.com");
		assertNotNull(businessUser);
		
		logger.info("Fetching saved business category reference data");
		
		BusinessCategory category  = businessDaoImpl.findBusinessCategoryByName("Patnership");
		
		logger.info("Fetching saved business service reference data");

		BusinessServiceType service = businessDaoImpl.findBusinessServiceTypeByName("Education and Training");
		
		logger.info("Creating new business object");

		Business newBusiness = new Business("Shopify", "shopify@mybusiness.com", 
				category,service , businessUser);
		
		logger.info("saving new business");

		businessDaoImpl.save(newBusiness);
		
		logger.info("Fetching saved business ");

		int businessId = newBusiness.getBizId();
		Business savedBusiness = businessDaoImpl.findById(businessId);
		
		assertNotNull(savedBusiness);
		
		logger.info("Fetching saved business successful");

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
