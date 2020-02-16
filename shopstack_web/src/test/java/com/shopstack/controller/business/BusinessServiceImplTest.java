package com.shopstack.controller.business;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.shopstack.entities.business.Business;
import com.shopstack.service.business.BusinessService;

public class BusinessServiceImplTest {

	
	@Mock
	private BusinessService busienssServiceImpl;
	
	
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

}
