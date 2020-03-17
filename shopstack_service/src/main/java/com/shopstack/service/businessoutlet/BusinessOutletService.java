package com.shopstack.service.businessoutlet;

import com.shopstack.model.business.BusinessOutlet;

public interface BusinessOutletService {
	
	public void save(BusinessOutlet newBusinessOutlet);
	
	public BusinessOutlet findById(int outletId);
}
