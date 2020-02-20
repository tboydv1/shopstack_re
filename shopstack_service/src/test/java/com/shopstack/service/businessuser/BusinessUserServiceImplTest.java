package com.shopstack.service.businessuser;

import static org.mockito.Mockito.mock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.shopstack.entities.businessuser.BusinessUser;

/**
 * @author oluwatobi
 *
 */
@ContextConfiguration("classpath:service-layer-context.xml")
@RunWith(SpringRunner.class)
public class BusinessUserServiceImplTest {

	
	@Mock
	private BussinessUserService businessUserServiceImplMock;
	
	
	@Before
	public void setUp() throws Exception {
		
		businessUserServiceImplMock = mock(BussinessUserService.class);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void saveNewUserTest() throws EmailExistsException {
		
		BusinessUser newUser = new BusinessUser();
		
		when(businessUserServiceImplMock.registerNewUserAccount(isA(BusinessUser.class),
				isA(String.class))).thenReturn(newUser);
		
		businessUserServiceImplMock.registerNewUserAccount(newUser, "ROLE_USER");
		
		verify(businessUserServiceImplMock, times(1)).registerNewUserAccount(newUser, "ROLE_USER");
	}
	


	

}
