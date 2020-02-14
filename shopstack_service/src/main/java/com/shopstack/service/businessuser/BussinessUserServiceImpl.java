package com.shopstack.service.businessuser;

import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopstack.dao.businessuser.BusinessUserDao;
import com.shopstack.entities.businessuser.BusinessUser;
import com.shopstack.entities.businessuser.Role;
import com.shopstack.entities.businessuser.Status;

/**
 * @author oluwatobi
 *
 */
@Service
public class BussinessUserServiceImpl implements BussinessUserService{

	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	private BusinessUserDao bussinessUserDaoImpl;
	

	@Override
	public BusinessUser registerNewUserAccount(BusinessUser businessUser, String role) throws EmailExistsException {
		
		//check that user is not already registered		
		if (emailExsits(businessUser.getEmail())) {  
			
            throw new EmailExistsException(
              "There is an account with that email address:  + accountDto.getEmail()");
        
		}
		else {
			businessUser.addUserRoles(new Role(role));
			
			logger.info("Calling BusinessDAO save method");
			bussinessUserDaoImpl.saveUser(businessUser);
			
			return businessUser;
		
		}
	
	}

	private boolean emailExsits(String email) {
		
		 BusinessUser user = bussinessUserDaoImpl.loadUserByEmail(email);
	        if (user != null) {
	            return true;
	        }
	        return false;

	}	

	@Override
	public void activateUser(BusinessUser existingbusinessUser) {
		
		existingbusinessUser.setEnabled(true);
		existingbusinessUser.setStatus(Status.ACTIVE);
		bussinessUserDaoImpl.saveUser(existingbusinessUser);
		
	}

	@Override
	public void generateUserToken(BusinessUser businessUser) {
		
		String token = UUID.randomUUID().toString();
		businessUser.setToken(token);
		
	}

	@Override
	public BusinessUser findUserByToken(String token) {
		
		return bussinessUserDaoImpl.findByToken(token);
		
	}
	
}
