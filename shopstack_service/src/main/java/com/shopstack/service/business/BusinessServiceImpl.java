package com.shopstack.service.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopstack.dao.business.BusinessDao;
import com.shopstack.entities.business.Business;
import com.shopstack.entities.business.BusinessCategory;
import com.shopstack.entities.business.BusinessServiceType;

@Service
public class BusinessServiceImpl implements BusinessService{

	@Autowired
	private BusinessDao businessDaoImpl;
	

	@Override
	public void saveBusiness(Business newBusiness) {
		
			businessDaoImpl.save(newBusiness);		
	}

	@Override
	public List<BusinessCategory> findAllCategories() {
		
		return businessDaoImpl.findAll();
	}

	@Override
	public List<BusinessServiceType> findAllServices() {
			
		return businessDaoImpl.findAllServiceTypes();
	}

	@Override
	public BusinessServiceType findBusinessServiceType(String nameString) {
			
		return businessDaoImpl.findBusinessServiceTypeByName(nameString);
	}

	@Override
	public BusinessCategory findBusinessCategory(String categoryName) {
		// TODO Auto-generated method stub
		return businessDaoImpl.findBusinessCategoryByName(categoryName);
	}
	
	

}
