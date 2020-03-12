package com.shopstack.repository.business;

import com.shopstack.model.business.Business;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author oluwatobi
 *
 */
public interface BusinessRepository extends JpaRepository<Business, Integer> {


//	public Business findByEmail(String bizEmail);

}
