package com.rent.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="login_credential")
public class LoginCredentials {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long login_cred_id;
	
	@Column(name="employee_username")
	private String employee_username;
	
	
	@Column(name="employee_password")
	private String employee_password;

	@Column(name="employee_role")
	private String employee_role;
	public long getLogin_cred_id() {
		return login_cred_id;
	}


	public void setLogin_cred_id(long login_cred_id) {
		this.login_cred_id = login_cred_id;
	}


	public String getEmployee_username() {
		return employee_username;
	}


	public void setEmployee_username(String employee_username) {
		this.employee_username = employee_username;
	}


	public String getEmployee_password() {
		return employee_password;
	}


	public void setEmployee_password(String employee_password) {
		this.employee_password = employee_password;
	}





	public String getEmployee_role() {
		return employee_role;
	}


	public void setEmployee_role(String employee_role) {
		this.employee_role = employee_role;
	}


	public LoginCredentials(long login_cred_id, String employee_username, String employee_password,
			String employee_role) {
		super();
		this.login_cred_id = login_cred_id;
		this.employee_username = employee_username;
		this.employee_password = employee_password;
		this.employee_role = employee_role;
	}


	public LoginCredentials() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
