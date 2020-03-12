package com.shopstack.model.business;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;
//import javax.validation.constraints.NotNull;

/**
 * @author oluwatobi
 *
 */
@Entity
@Table(name="business_category")
public class BusinessCategory {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="biz_category_id")
	private int bizCategoryid;
	
	@NotNull
	@Column(name="biz_category_name")
	private String bizCategoryName;

	@OneToMany(mappedBy = "bizCategory")
	private List<Business> businessList;
	
	public BusinessCategory() {
		
	}
	
	public BusinessCategory(String categoryName) {

		this.bizCategoryName = categoryName;
	}

	public int getBizCategoryid() {
		return bizCategoryid;
	}

	public void setBizCategoryid(int bizCategoryid) {
		this.bizCategoryid = bizCategoryid;
	}

	public String getBizCategoryName() {
		return bizCategoryName;
	}

	public void setBizCategoryName(String bizCategoryName) {
		this.bizCategoryName = bizCategoryName;
	}

	public List<Business> getBusinessList() {
		return businessList;
	}

	public void setBusinessList(List<Business> business) {
		this.businessList = business;
	}


	@Override
	public String toString() {
		return "BusinessCategory [bizCategoryid=" + bizCategoryid + ", bizCategoryName=" + bizCategoryName + "]";
	}


}
