package com.shopstack.service.business;

import java.util.List;

import com.shopstack.model.business.Business;
import com.shopstack.model.business.BusinessCategory;
import com.shopstack.model.business.BusinessServiceType;
import com.shopstack.repository.business.BusinessCategoryRepository;
import com.shopstack.repository.business.BusinessRepository;
import com.shopstack.repository.business.BusinessServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class BusinessServiceImpl implements BusinessService{

	@Autowired
	private BusinessRepository businessRepository;

	@Autowired
	private BusinessCategoryRepository businessCategoryRepository;

	@Autowired
	private BusinessServiceTypeRepository businessServiceTypeRepository;
	

	@Override
	public void save(Business newBusiness) {
		
		businessRepository.save(newBusiness);
	}

	@Override
	public List<BusinessCategory> getAllCategories() {
		
		return businessCategoryRepository.findAll();
	}

	@Override
	public List<BusinessServiceType> getAllServices() {
			
		return businessServiceTypeRepository.findAll();
	}


}
