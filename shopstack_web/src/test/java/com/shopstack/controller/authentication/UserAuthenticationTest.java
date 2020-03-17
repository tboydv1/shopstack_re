package com.shopstack.controller.authentication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@WebAppConfiguration
public class UserAuthenticationTest {

	
	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;
	
//
//	@Before
//	public void setUp() throws Exception {
//
//		mvc = MockMvcBuilders.webAppContextSetup(context)
////							 .apply(springSecurity())
//							 .build();
//	}
//
//
//	@Test
//	public void test() throws Exception {
//
//		mvc.perform(formLogin("/auth")
//				.user("admin")
//				.password("pass"));
//	}

}
