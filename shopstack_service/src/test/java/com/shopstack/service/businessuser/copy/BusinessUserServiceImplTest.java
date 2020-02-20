package com.shopstack.service.businessuser.copy;

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
import com.shopstack.service.businessuser.BussinessUserService;
import com.shopstack.service.businessuser.EmailExistsException;

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
		
		BusinessUser tempUser = new 
				BusinessUser("Test", "TestLast", "Test@mail.com", "0909796996", "testpass");
		
		when(businessUserServiceImplMock.registerNewUserAccount(isA(BusinessUser.class),
				isA(String.class))).thenReturn(tempUser);
		
		businessUserServiceImplMock.registerNewUserAccount(tempUser, "ROLE_USER");
		
		verify(businessUserServiceImplMock, times(1)).registerNewUserAccount(tempUser, "ROLE_USER");
	}

}
