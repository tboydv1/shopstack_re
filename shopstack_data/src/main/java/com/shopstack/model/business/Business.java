package com.shopstack.model.business;

//import com.shopstack.entities.businessuser.BusinessUser;

import com.shopstack.model.businessuser.BusinessUser;
import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import javax.validation.constraints.NotNull;


/**
 * @author oluwatobi
 *
 */

@Entity
@Table(name="ss_business")
public class Business {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="biz_id")
	private int bizId;
	
	@NotNull
	@Column(name="biz_name")
	private String bizName;
	
	@Column(name="biz_logo")
	private String bizLogoUri;
	
	@NotNull
	@Column(name="biz_email")
	private String bizEmail;
	
	@Column(name="biz_website")
	private String bizWebsite;
	
	@Column(name="biz_phone")
	private String bizPhone;
	
	@CreationTimestamp
	@Column(name="date_created")
	private Date dateAdded;
	
	@NotNull
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="biz_category_id")
	private BusinessCategory bizCategory;
	
	@NotNull()
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="biz_service_id")
	private BusinessServiceType bizService;
	
	@OneToMany(mappedBy= "business", cascade = {CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<BusinessOutlet> businessOutlets;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="biz_creator")
	private BusinessUser creator;
	
	public Business() {
		
	}

	public Business(String bizName, @NotNull String email, @NotNull BusinessCategory bizCategory,
			@NotNull BusinessServiceType bizService, @NotNull BusinessUser creator) {

		this.bizName = bizName;
		this.bizEmail = email;
		this.bizCategory = bizCategory;
		this.bizService = bizService;
		this.creator = creator;
	}

	public int getBizId() {
		return bizId;
	}

	public void setBizId(int bizId) {
		this.bizId = bizId;
	}


	public String getBizName() {
		return bizName;
	}

	public void setBizName(String bizName) {
		this.bizName = bizName;
	}

	public String getBizLogoUri() {
		return bizLogoUri;
	}

	public void setBizLogoUri(String bizLogoUri) {
		this.bizLogoUri = bizLogoUri;
	}

	public String getBizEmail() {
		return bizEmail;
	}

	public void setBizEmail(String bizEmail) {
		this.bizEmail = bizEmail;
	}

	public String getBizWebsite() {
		return bizWebsite;
	}

	public void setBizWebsite(String bizWebsite) {
		this.bizWebsite = bizWebsite;
	}

	public String getBizPhone() { return bizPhone; }

	public void setBizPhone(String bizPhone) {
		this.bizPhone = bizPhone;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	
	public void addBusinessOutlet(BusinessOutlet tempBusinessOutlet) {
		
		if(businessOutlets == null) {
			businessOutlets = new ArrayList<>();
		}
		businessOutlets.add(tempBusinessOutlet);
	}

	public BusinessCategory getBizCategory() {
		return bizCategory;
	}

	public void setBizCategory(BusinessCategory bizCategory) {

		this.bizCategory = bizCategory;
	}


	public BusinessServiceType getBizServiceType() {
		return bizService;
	}

	public void setBizServiceType(BusinessServiceType bizService) {

		this.bizService = bizService;
	}

	public List<BusinessOutlet> getBusinessOutlets() {
		return businessOutlets;
	}

	public void setBusinessOutlets(List<BusinessOutlet> businessOutlets) {
		this.businessOutlets = businessOutlets;
	}
	
	

	public BusinessUser getCreator() {
		return creator;
	}

	public void setCreator(BusinessUser creator) {
		this.creator = creator;
	}

	@Override
	public String toString() {
		return "Business [bizId=" + bizId + ", bizName=" + bizName + ", bizLogoUri=" + bizLogoUri + ", bizEmail="
				+ bizEmail + ", bizWebsite=" + bizWebsite + ", bizPhone=" + bizPhone + ", dateAdded=" + dateAdded
				+ ", bizCategory=" + bizCategory + ", bizService=" + bizService + ", businessOutlets=" + businessOutlets
				+ ", creator=" + creator + "]";
	}

}