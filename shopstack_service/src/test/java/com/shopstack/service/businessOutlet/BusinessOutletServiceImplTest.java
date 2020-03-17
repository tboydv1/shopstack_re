package com.shopstack.service.businessOutlet;

import java.util.logging.Logger;


import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.shopstack.service.businessoutlet.BusinessOutletService;

@ContextConfiguration("classpath:/service-layer-context.xml")
public class BusinessOutletServiceImplTest {

	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Mock
	private BusinessOutletService businessServiceImp;
	
//	@Autowired
//	 private BusinessDao businessService;
	
//	@Before
//	public void setUp() throws Exception {
//
//		businessServiceImp= mock(BusinessOutletService.class);
//
//	}
//
//	@Test
//	public void saveNullBusinessOutletTest() {
//		logger.info("it comfirmed");
//		assertNotNull(businessServiceImp);
//	}
//
//	@Test
//	public void saveNewBusinessOutletTest() {
//
//
////		BusinessOutlet theBusiness = businessServiceImp.findOutle;
//
//		BusinessOutlet tempBusinessOutlet = new BusinessOutlet();
//
//		doNothing().when(businessServiceImp).saveBusinessOutlet(isA(tempBusinessOutlet.getClass()));
//
//		businessServiceImp.saveBusinessOutlet(tempBusinessOutlet);
//
//////		int outletId = theBusiness.getOutletId();
////		BusinessOutlet businessServiceExist =  businessServiceImp.findOutletById(outletId);
//
//		verify(businessServiceImp, times(1)).saveBusinessOutlet(tempBusinessOutlet);;
//
//
//	}

}
