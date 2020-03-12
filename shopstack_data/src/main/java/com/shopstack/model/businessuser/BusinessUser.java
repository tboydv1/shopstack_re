package com.shopstack.model.businessuser;


import com.shopstack.model.business.Business;
import com.shopstack.model.business.BusinessOutlet;
import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author oluwatobi
 *
 */
@Entity
@Table(name="ss_user")
public class BusinessUser implements Serializable {


	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="ss_user_id")
	private Integer userId;
	
	@Column(name="ss_title")
	private String title;
	
	@NotNull
	@Column(name="ss_first_name")
	private String firstName;
	
	@NotNull
	@Column(name="ss_last_name")
	private String lastName;
	
	@Column(name="ss_address")
	private String address;
	
	@NotNull
	@Column(name="ss_email")
	private String email;
	
	@NotNull
	@Column(name="ss_phone_number")
	private String phoneNumber;
	
	
	@CreationTimestamp
	@Column(name="ss_date_joined")
	private Date dateJoined;
	
	@NotNull
	@Column(name ="ss_password")
	private String password;
	
	
	@Column(name="ss_enabled")
	private boolean enabled;


	@Column(name="ss_status")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name="ss_token")
	private String token;
	
	@OneToMany(mappedBy="userEmail")
	private List<Role> userRoles;
	
	@ManyToMany(
			cascade= {CascadeType.DETACH, CascadeType.REFRESH,
			CascadeType.MERGE, CascadeType.PERSIST}
			)
	@JoinTable(
			name="business_outlet_has_employee",
			joinColumns=@JoinColumn(name="ss_user_id"),
			inverseJoinColumns=@JoinColumn(name="ss_business_outlet_id")
	)
	private List<BusinessOutlet> businessOutlets;

	@OneToMany(mappedBy = "creator")
	private List<Business> business;
	
	
	public BusinessUser() {
		
		this.enabled = false;
		this.status = Status.PENDING;
		
	}
	
	public BusinessUser(@NotNull String firstName, @NotNull String lastName, @NotNull  String email,
			@NotNull String contactNumber, @NotNull String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = contactNumber;
		this.password = password;
		this.enabled = false;
		this.status = Status.PENDING;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Integer getUserId(){  return this.userId; }

	public void setUserId(Integer userId) { this.userId = userId; }

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return phoneNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.phoneNumber = contactNumber;
	}

	public Date getDateJoined() {
		return dateJoined;
	}

	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public List<Role> getUserRoles() {
		return userRoles;
	}


	public void addUserRoles(Role newRole) {
		
		if((userRoles == null)) {
			userRoles = new ArrayList<>();
		}
		
		userRoles.add(newRole);
	}


	public List<BusinessOutlet> getBusinessOutlets() {
		return businessOutlets;
	}


	public void setBusinessOutlets(List<BusinessOutlet> business) {
		this.businessOutlets = business;
	}

	public void setUserRoles(List<Role> userRoles) {
		this.userRoles = userRoles;
	}

	public Status getUserStatus() {
		return status;
	}

	public void setUserStatus(Status userStatus) {
		this.status = userStatus;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<Business> getBusiness() {
		return business;
	}

	public void setBusiness(List<Business> business) {
		this.business = business;
	}

	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("\nFirstname: " + getFirstName())
				.append("\n")
				.append("Lastname: " + getLastName())
				.append("\n")
				.append("Email: " + getEmail())
				.append("\n")
				.append("Password: " + getPassword());

		return builder.toString();

	}
	
}
