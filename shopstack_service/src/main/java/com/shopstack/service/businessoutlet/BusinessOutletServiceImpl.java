package com.shopstack.service.businessoutlet;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopstack.dao.business.BusinessDao;
import com.shopstack.entities.business.BusinessOutlet;

@Service
public class BusinessOutletServiceImpl implements BusinessOutletService {
	
	@Autowired
	private BusinessDao businessOutletImpl;
//
	@Override
	public void saveBusinessOutlet(BusinessOutlet newBusinessOutlet)
	{
	
		businessOutletImpl.save(newBusinessOutlet);		
	}

   @Override
  public BusinessOutlet findOutletById(int outletId) {
	
	return businessOutletImpl.findOutletById(outletId);
}

}
