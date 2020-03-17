package com.shopstack.service.businessuser;

import static org.mockito.Mockito.mock;

import com.shopstack.ServiceConfig;
import com.shopstack.model.businessuser.BusinessUser;
import com.shopstack.repository.businessuser.BusinessUserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author oluwatobi
 *
 */
@SpringBootTest(classes = ServiceConfig.class)
public class BusinessUserServiceImplTest {

	
	@Mock
	private BusinessUserRepository businessUserRepository;

	BusinessUser newUser;
	
	@BeforeEach
	public void setUp() throws Exception {
		newUser = new BusinessUser();
		businessUserRepository = mock(BusinessUserRepository.class);
	}

	@AfterEach
	public void tearDown() throws Exception {
	}
	
	@Test
	public void saveNewUserTest() throws EmailExistsException {

		when(businessUserRepository.save(isA(BusinessUser.class))).thenReturn(newUser);
		
		businessUserRepository.save(newUser);
		
		verify(businessUserRepository, times(1)).save(newUser);
	}

}
