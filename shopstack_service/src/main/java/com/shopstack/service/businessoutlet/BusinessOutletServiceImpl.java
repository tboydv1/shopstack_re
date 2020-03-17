package com.shopstack.service.businessoutlet;



import com.shopstack.model.business.BusinessOutlet;
import com.shopstack.repository.business.BusinessOutletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BusinessOutletServiceImpl implements BusinessOutletService {
	
	@Autowired
	private BusinessOutletRepository businessOutletRepository;
//
	@Override
	public void save(BusinessOutlet newBusinessOutlet)
	{
		businessOutletRepository.save(newBusinessOutlet);
	}

   @Override
  public BusinessOutlet findById(int outletId) {
	
	return businessOutletRepository.getOne(outletId);

  }

}
