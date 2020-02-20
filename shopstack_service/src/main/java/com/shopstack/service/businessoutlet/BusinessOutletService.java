package com.shopstack.service.businessoutlet;

import com.shopstack.entities.business.BusinessOutlet;

public interface BusinessOutletService {
	
	public void saveBusinessOutlet(BusinessOutlet newBusinessOutlet);
	
	public BusinessOutlet findOutletById(int outletId);
}
