package com.shopstack.model.business;

import javax.persistence.*;
import java.util.List;

/**
 * @author oluwatobi
 *
 */
@Entity
@Table(name="business_services")
public class BusinessServiceType {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="biz_service_id")
	private Integer bizServiceId;
	
	@Column(name="biz_service_name")
	private String bizServiceName;

	@OneToMany(mappedBy = "bizService")
	private List<Business> businessList;
	
	public BusinessServiceType() {
		
	}

	public BusinessServiceType(String businessService) {
		
		this.bizServiceName = businessService;
	}

	public Integer getBizServiceId() {
		return bizServiceId;
	}

	public void setBizServiceId(Integer bizServiceId) {
		this.bizServiceId = bizServiceId;
	}

	public String getBizServiceName() {
		return bizServiceName;
	}

	public void setBizServiceName(String bizServiceName) {
		this.bizServiceName = bizServiceName;
	}

	@Override
	public String toString() {
		return "BusinessService [bizServiceId=" + bizServiceId + ", bizServiceName=" + bizServiceName + "]";
	}
	
}
