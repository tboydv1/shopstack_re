package com.shopstack.controller.customer;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.*;



import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import com.shopstack.service.customer.CustomerService;

public class CustomerControllerTest {
	
//	private Logger logger = Logger.getLogger(getClass().getName());

	
	@Mock
	private CustomerService customerserviceImpl;
	
	
	
//	@Before
//	public void setUp() throws Exception {
//
//		customerserviceImpl = mock(CustomerService.class);
//	}
//
//	@Test
//	public void getCustomerRequestFormTest() {
//		assertNotNull(customerserviceImpl);
//	}
//
////	@Test
////	public void addCustomer() throws Exception {
////
////
////		Customer myCustomer = new Customer("adeola@gmail.com");
////
////		doNothing().when(customerserviceImpl).addCustomer(isA(Customer.class));
////
////		customerserviceImpl.addCustomer(myCustomer);
////
////		verify(customerserviceImpl, times(1)).addCustomer(myCustomer);
////
////	}
////	@Test
////	public void listCustomers() throws Exception {
////
////
////		Customer myCustomer = new Customer("adeola@gmail.com");
////
////		doNothing().when(customerserviceImpl).addCustomer(isA(Customer.class));
////
////
////		verify(customerserviceImpl, times(1)).addCustomer(myCustomer);
////
////	}
}
