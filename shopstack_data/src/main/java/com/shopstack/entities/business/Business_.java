package com.shopstack.entities.business;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.shopstack.entities.businessuser.BusinessUser;

@StaticMetamodel(Business.class)
public class Business_ {

	public static volatile SetAttribute<Business, BusinessUser> businessEntities;
}
