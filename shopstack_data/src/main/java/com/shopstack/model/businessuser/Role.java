package com.shopstack.model.businessuser;

import javax.persistence.*;


/**
 * @author oluwatobi
 *
 */
@Entity
@Table(name="user_roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="role_id")
	private int roleId;
	
	@Column(name="role_name")
	private String role;
	
	@ManyToOne
	@JoinColumn(name="ss_user_email")
	private BusinessUser userEmail;
	
	public Role() {
		
	}
	
	public Role(int id, String role) {
		
	}
	
	public Role(String role) {
		
		this.role = role;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public BusinessUser getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(BusinessUser userEmail) {
		this.userEmail = userEmail;
	}
	
	

	        

	
	
	

}
