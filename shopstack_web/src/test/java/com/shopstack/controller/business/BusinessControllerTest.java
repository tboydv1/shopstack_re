package com.shopstack.controller.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.shopstack.entities.business.Business;
import com.shopstack.service.business.BusinessService;


@ContextConfiguration("file:src/main/webapp/WEB-INF/web-layer-context-servlet.xml")
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class BusinessControllerTest {

	
	@Mock
	private BusinessService busienssServiceImpl;
	
	@Autowired
	private BusinessController businessController;
	
	
	@Before
	public void setUp() throws Exception {
		
		busienssServiceImpl = mock(BusinessService.class);		
	}

	@After
	public void tearDown() throws Exception {
		
		
	}

	@Test
	public void saveNewBusinessTest() {
		
		Business newBusiness = new Business();
		
		doNothing().when(busienssServiceImpl).saveBusiness(isA(Business.class));
		busienssServiceImpl.saveBusiness(newBusiness);
		
		verify(busienssServiceImpl, times(1)).saveBusiness(newBusiness);
	}
	
	@Test
	public void findServiceTypeIdTest() {
		
		businessController.getBusinessServiceTypes();
		
		int id = businessController.findByServiceTypeId("Accomodation and Food Services");
		assertEquals(5, id);
		
	}

	@Test
	public void findCategoryIdTest() {
		
		businessController.getCategories();
		
		int id = businessController.findBusinessCategoryId("Charity or association");
		assertEquals(3, id);
		
	}

}
