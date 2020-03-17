package com.shopstack.service.customer;


import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.logging.Logger;

import org.mockito.Mock;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;



@ContextConfiguration("classpath:/service-layer-context.xml")
public class CustomerServiceImplTest {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Mock
	private CustomerService customerServiceImpl;


//	@Before
//	public void setUp() throws Exception {
//
//		customerServiceImpl = mock(CustomerService.class);
//	}

//	@Test
//	public void  cutomerServiceDaoInitializeTest() {
//		logger.info("creating object");
//		assertNotNull(customerServiceImpl);
//	}
//
//	@Test
//	public void saveNewCustomerTest() {
//
//
//			Customer customer = new Customer("Brand@gmail");
//			doNothing().when(customerServiceImpl).addCustomer(isA(Customer.class));
//
//			customerServiceImpl.addCustomer(customer);
//
//			verify(customerServiceImpl, times(1)).addCustomer(customer);
//
//
//
//	}
}
