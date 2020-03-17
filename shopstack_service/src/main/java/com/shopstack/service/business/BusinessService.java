package com.shopstack.service.business;

import com.shopstack.model.business.Business;
import com.shopstack.model.business.BusinessCategory;
import com.shopstack.model.business.BusinessServiceType;

import java.util.List;



public interface BusinessService {
	
	public void save(Business business);
	
	public List<BusinessCategory> getAllCategories();
	
	public List<BusinessServiceType> getAllServices();

}
