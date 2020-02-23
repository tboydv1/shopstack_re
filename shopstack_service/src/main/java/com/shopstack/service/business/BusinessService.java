package com.shopstack.service.business;

import java.util.List;

import com.shopstack.entities.business.Business;
import com.shopstack.entities.business.BusinessCategory;
import com.shopstack.entities.business.BusinessServiceType;

public interface BusinessService {
	
	public void saveBusiness(Business business);
	
	public List<BusinessCategory> findAllCategories();
	
	public List<BusinessServiceType> findAllServices();
	
	public BusinessServiceType findBusinessServiceType(String nameString);
	
	public BusinessCategory findBusinessCategory(String categoryName);
	
	
}
