package com.shopstack.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource securityDataSource;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			
		auth.jdbcAuthentication()
				.dataSource(securityDataSource)
				.usersByUsernameQuery("select ss_email, ss_password, ss_enabled "
			        + "from ss_user "
			        + "where ss_email = ?")
				.authoritiesByUsernameQuery("select ss_user_email, role_name "
			        + "from user_roles "
			        + "where ss_user_email = ?");
		
//		UserBuilder users = User.withDefaultPasswordEncoder();
//		
//		auth.inMemoryAuthentication()
//			.withUser(users.username("john").password("test123").roles("EMPLOYEE"))
//			.withUser(users.username("mary").password("test123").roles("MANAGER"))
//			.withUser(users.username("susan").password("test123").roles("ADMIN"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
			
		http
	        .authorizeRequests()
	        .antMatchers("/**").permitAll()
		.and()
		.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/auth")
			.defaultSuccessUrl("/user/dashboard")
			.permitAll()
		.and()
			.logout()
			.logoutSuccessUrl("/")
			.permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
	}
	
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		
//	    web.ignoring().antMatchers("/");
	}

	
	
	
	
}
