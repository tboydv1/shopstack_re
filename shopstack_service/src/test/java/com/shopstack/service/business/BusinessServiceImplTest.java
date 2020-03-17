package com.shopstack.service.business;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;


import com.shopstack.ServiceConfig;
import com.shopstack.model.business.Business;
import com.shopstack.model.business.BusinessCategory;
import com.shopstack.model.business.BusinessServiceType;
import com.shopstack.repository.business.BusinessCategoryRepository;
import com.shopstack.repository.business.BusinessRepository;
import com.shopstack.repository.business.BusinessServiceTypeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = ServiceConfig.class)
public class BusinessServiceImplTest {

	
	@Mock
	private BusinessRepository businessRepository;

	@Mock
	private BusinessCategoryRepository businessCategoryRepository;

	@Mock
	private BusinessServiceTypeRepository businessServiceTypeRepository;
	
	
	@BeforeEach
	public void setUp() throws Exception {

		businessRepository = mock(BusinessRepository.class);

		businessCategoryRepository = mock(BusinessCategoryRepository.class);

		businessServiceTypeRepository = mock(BusinessServiceTypeRepository.class);
	}

	@AfterEach
	public void tearDown() throws Exception {


	}

	@Test
	public void saveNewBusinessTest() {

		Business newBusiness = new Business();

		when(businessRepository.save(isA(Business.class))).thenReturn(newBusiness);
		businessRepository.save(newBusiness);

		verify(businessRepository, times(1)).save(newBusiness);
	}


	@Test
	public void getBusinessCategories() {

		List<BusinessCategory> category = new ArrayList<>();

		when(businessCategoryRepository.findAll()).thenReturn(category);
		businessRepository.findAll();

		verify(businessRepository, times(1)).findAll();

	}

	@Test
	public void getBusinessServices() {

		List<BusinessServiceType> services = new ArrayList<>();

		when(businessServiceTypeRepository.findAll()).thenReturn(services);
		businessRepository.findAll();

		verify(businessRepository, times(1)).findAll();

	}

}
