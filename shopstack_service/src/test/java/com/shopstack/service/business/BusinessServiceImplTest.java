package com.shopstack.service.business;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.shopstack.entities.business.Business;
import com.shopstack.entities.business.BusinessCategory;
import com.shopstack.entities.business.BusinessServiceType;

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
	
	
	@Test
	public void getBusinessCategories() {
		
		List<BusinessCategory> category = new ArrayList<>();
		
		when(busienssServiceImpl.findAllCategories()).thenReturn(category);
		busienssServiceImpl.findAllCategories();
		
		verify(busienssServiceImpl, times(1)).findAllCategories();
		
	}
	
	@Test
	public void getBusinessServices() {
		
		List<BusinessServiceType> services = new ArrayList<>();
		
		when(busienssServiceImpl.findAllServices()).thenReturn(services);
		busienssServiceImpl.findAllServices();
		
		verify(busienssServiceImpl, times(1)).findAllServices();
		
	}

}
