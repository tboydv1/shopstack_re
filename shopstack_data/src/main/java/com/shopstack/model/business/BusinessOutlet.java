package com.shopstack.model.business;


import com.shopstack.model.businessuser.BusinessUser;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

//import javax.validation.constraints.NotNull;

/**
 * @author oluwatobi
 *
 */


@Entity
@Table(name="ss_business_outlet")
public class BusinessOutlet {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="ss_business_outlet_id")
	private Integer outletId;
	
	@Column(name="ss_outlet_display_name")
	@NotNull
	private String displayName; 
	
	@Column(name="email")
	private String email;
	
	@NotNull
	@Column(name="location")
	private String location;
	
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="date_Added")
	private Date dateAdded;
	
	@ManyToOne(fetch= FetchType.LAZY,
				cascade= {CascadeType.DETACH, CascadeType.REFRESH,
				CascadeType.MERGE, CascadeType.PERSIST}
	)
	@JoinColumn(name="ss_business_biz_id")
	private Business business;

	@ManyToMany(
			cascade= {CascadeType.DETACH, CascadeType.REFRESH,
			CascadeType.MERGE, CascadeType.PERSIST}
			)
	@JoinTable(
			name="business_outlet_has_employee",
			joinColumns=@JoinColumn(name="ss_business_outlet_id"),
			inverseJoinColumns=@JoinColumn(name="ss_user_id")
	)
	private List<BusinessUser> employees;

//	@ManyToMany(
//			cascade= {CascadeType.DETACH, CascadeType.REFRESH,
//					CascadeType.MERGE, CascadeType.PERSIST}
//	)
//	@JoinTable(
//			name="business_outlet_has_product",
//			joinColumns =@JoinColumn(name="business_outlet_id"),
//			inverseJoinColumns = @JoinColumn(name="product_code")
//	)
//	private List<Product> products;

	
	public BusinessOutlet() {
		
	}
	
	
	public BusinessOutlet(@NotNull String displayName, @NotNull String location, Business business) {
		super();
		this.displayName = displayName;
		this.location = location;
		this.business = business;
	}

	public Integer getOutletId() {
		return outletId;
	}

	public void setOutletId(Integer outletId) {
		this.outletId = outletId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business businessId) {
		this.business = businessId;
	}

//	public List<Product> getProducts() { return products; }
//
//	public void setProducts(List<Product> products) { this.products = products; }

	public String getDisplayName() { return displayName; }

	public void setDisplayName(String displayName) { this.displayName = displayName; }

	@Override
	public String toString() {
		return "BusinessOutlet [outletId=" + outletId + ", email=" + email + ", location=" + location + ", phone="
				+ phone + ", dateAdded=" + dateAdded + ", businessId=" + business + "]";
	}
	
//	private Account account;
	
	
}
