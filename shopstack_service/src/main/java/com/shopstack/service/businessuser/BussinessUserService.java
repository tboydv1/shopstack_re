package com.shopstack.service.businessuser;

import com.shopstack.model.businessuser.BusinessUser;

import java.util.List;

/**
 * @author oluwatobi
 *
 */
public interface BussinessUserService {

	public void generateUserToken(BusinessUser businessUser);
		
	public BusinessUser registerNewUserAccount(BusinessUser businessUser, String role) throws EmailExistsException;
	
	public void activateUser(BusinessUser existingbusinessUser);
	
	public BusinessUser findByToken(String token);

	public BusinessUser findByEmail(String userEmail);

	public List<BusinessUser> findAll();
}
