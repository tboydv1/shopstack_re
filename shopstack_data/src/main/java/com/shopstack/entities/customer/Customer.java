package com.shopstack.entities.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import com.shopstack.entities.business.BusinessOutlet;

/**
 * @author adefunmi
 *
 */
@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customer_id")
	private int customerId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	@NotNull
	@Email
	@Column(name="email")
	private String email;
	 
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@ManyToOne
	@JoinColumn(name="ss_business_outlet_ss_business_outlet_id")
	private BusinessOutlet businessOutlet;
	
	
	public Customer() {
		
	}
	
	public Customer(@NotNull String email) {
		this.email = email;
	}

	public Customer(String info, BusinessOutlet existingBusiness) {
		this.email = info;
		this.businessOutlet = existingBusiness;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public BusinessOutlet getBusinessOutlet() {
		return businessOutlet;
	}

	public void setBusinessOutlet(BusinessOutlet businessOutlet) {
		this.businessOutlet = businessOutlet;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", title=" + title + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", businessOutlet=" 
				+ "]";
	}
	
	

}
