package com.shopstack.service.businessuser;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import com.shopstack.model.businessuser.BusinessUser;
import com.shopstack.model.businessuser.Role;
import com.shopstack.model.businessuser.Status;
import com.shopstack.repository.businessuser.BusinessUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author oluwatobi
 *
 */
@Service
public class BussinessUserServiceImpl implements BussinessUserService{

	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	private BusinessUserRepository businessUserRepository;
	

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
			businessUserRepository.save(businessUser);
			
			return businessUser;
		
		}
	
	}

	private boolean emailExsits(String email) {
		
		 BusinessUser user = businessUserRepository.findByEmail(email);
	        if (user != null) {
	            return true;
	        }
	        return false;

	}	

	@Override
	public void activateUser(BusinessUser existingbusinessUser) {
		
		existingbusinessUser.setEnabled(true);
		existingbusinessUser.setStatus(Status.ACTIVE);

		businessUserRepository.save(existingbusinessUser);
		
	}

	@Override
	public void generateUserToken(BusinessUser businessUser) {
		
		String token = UUID.randomUUID().toString();
		businessUser.setToken(token);
		
	}

	@Override
	public BusinessUser findByToken(String token) {
		
		return businessUserRepository.findByToken(token);
		
	}

	@Override
	public BusinessUser findByEmail(String userEmail) {
			
		return businessUserRepository.findByEmail(userEmail);
	}

	@Override
	public List<BusinessUser> findAll() {

		return businessUserRepository.findAll();
	}

}
