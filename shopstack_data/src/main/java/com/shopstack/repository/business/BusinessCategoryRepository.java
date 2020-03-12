package com.shopstack.repository.business;

import com.shopstack.model.business.BusinessCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessCategoryRepository extends JpaRepository <BusinessCategory, Integer> {
}
