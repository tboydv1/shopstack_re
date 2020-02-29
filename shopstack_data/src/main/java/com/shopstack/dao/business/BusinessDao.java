package com.shopstack.dao.business;

import java.util.List;

import com.shopstack.entities.business.Business;
import com.shopstack.entities.business.BusinessCategory;
import com.shopstack.entities.business.BusinessOutlet;
import com.shopstack.entities.business.BusinessServiceType;
import com.shopstack.entities.businessuser.BusinessUser;



/**
 * @author oluwatobi
 *
 */
public interface BusinessDao {

	public void save(Business newBusiness);
	
	public Business findByEmail(String bizEmail);
		
	public Business findById(int businessId);
	
	public List<BusinessCategory> findAll();
	
	public List<BusinessServiceType> findAllServiceTypes();
	
	public BusinessCategory findBusinessCategoryByName(String ObjectId);
	
	public BusinessServiceType findBusinessServiceTypeByName(String ObjectId);
	
	public BusinessOutlet findOutletById(int outletId);
	
	public void save(BusinessOutlet newBusinessOutlet);
}
