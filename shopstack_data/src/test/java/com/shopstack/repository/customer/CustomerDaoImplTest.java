package com.shopstack.repository.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * @author adefunmi
 *
 */
@Sql(scripts= {"classpath:/db/insert-into-business-and-user-data.sql"})
//@ContextConfiguration(classes= DataContextConfig.class)
//@RunWith(SpringRunner.class)
public class CustomerDaoImplTest {
	
//	private Logger logger = Logger.getLogger(CustomerDaoImplTest.class.getName());
//
//		@Autowired
//		private CustomerDao customerDaoImpl;
//
//		@Autowired
//		private BusinessDao businessDaoImpl;
//
//		@Autowired
//		private ComboPooledDataSource dataSource;
//
//	@Before
//	public void setUp() throws Exception {
//
//	}
//
//	@Test
//	public void dbInitializingDataSourceTest() {
//
//		assertNotNull(customerDaoImpl);
//		assertNotNull(dataSource);
//
//	}
//	@Test
//	public void addCustomerByEmail() {
//
//		try {
//
//				BusinessOutlet existingBusiness = businessDaoImpl.findOutletById(7);
//				assertNotNull(existingBusiness);
//
//				logger.info("Create new customer");
//				Customer newCustomer = new Customer("ajayibenson@gmail.com", existingBusiness);
//
//				customerDaoImpl.addCustomer(newCustomer);
//				logger.info("Successfully saved customer to the database");
//
//				Customer savedCustomer = customerDaoImpl.findById(newCustomer.getCustomerId());
//				assertNotNull(savedCustomer);
//			}
//
//			catch(Exception e) {
//				e.printStackTrace();
//				logger.warn("Error saving customer to the database");
//
//			}
//	}
}
