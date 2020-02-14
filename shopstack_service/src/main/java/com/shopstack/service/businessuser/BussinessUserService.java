package com.shopstack.service.businessuser;

import com.shopstack.entities.businessuser.BusinessUser;

/**
 * @author oluwatobi
 *
 */
public interface BussinessUserService {

	public void generateUserToken(BusinessUser businessUser);
		
	public BusinessUser registerNewUserAccount(BusinessUser businessUser, String role) throws EmailExistsException;
	
	public void activateUser(BusinessUser existingbusinessUser);
	
	public BusinessUser findUserByToken(String token);
}
