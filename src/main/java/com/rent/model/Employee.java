package com.rent.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="employee_name")
	private String employee_name;
	
	@Column(name="employee_lastname")
	private String employee_lastname;
	

	@Column(name="employee_username",unique = true)
	private String employee_username;
	
	
	@Column(name="employee_role")
	private String employee_role;
	
	public String getEmployee_role() {
		return employee_role;
	}

	public void setEmployee_role(String employee_role) {
		this.employee_role = employee_role;
	}

	@Column(name="finanacial_year")
	private String finanacial_year;
	
	@Column(name="decleration_status")
	private String decleration_status;
	
	@Column(name="decleration_date")
	private String decleration_date;
	
	@Column(name="address")
	private String address;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private	String state;
	
	@Column(name="pincode")
	private String pincode;
	
	@Column(name="rent_amount")
	private	String rent_amount;
	
	@Column(name="rent_amount_yearly")
	private String rent_amount_yearly;
	
	@Column(name="description")
	private String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	

	public String getDecleration_date() {
		return decleration_date;
	}

	public void setDecleration_date(String decleration_date) {
		this.decleration_date = decleration_date;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getEmployee_lastname() {
		return employee_lastname;
	}

	public void setEmployee_lastname(String employee_lastname) {
		this.employee_lastname = employee_lastname;
	}

//	public LoginCredentials getLogin_cred_id() {
//		return login_cred_id;
//	}
//
//	public void setLogin_cred_id(LoginCredentials login_cred_id) {
//		this.login_cred_id = login_cred_id;
//	}

	public String getEmployee_username() {
		return employee_username;
	}

	public void setEmployee_username(String employee_username) {
		this.employee_username = employee_username;
	}

	public String getFinanacial_year() {
		return finanacial_year;
	}

	public void setFinanacial_year(String finanacial_year) {
		this.finanacial_year = finanacial_year;
	}

	public String getDecleration_status() {
		return decleration_status;
	}

	public void setDecleration_status(String decleration_status) {
		this.decleration_status = decleration_status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getRent_amount() {
		return rent_amount;
	}

	public void setRent_amount(String rent_amount) {
		this.rent_amount = rent_amount;
	}

	public String getRent_amount_yearly() {
		return rent_amount_yearly;
	}

	public void setRent_amount_yearly(String rent_amount_yearly) {
		this.rent_amount_yearly = rent_amount_yearly;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	
	public Employee(long id, String employee_name, String employee_lastname, String employee_username,
			String employee_role, String finanacial_year, String decleration_status, String address, String city,
			String state, String pincode, String rent_amount, String rent_amount_yearly, String description) {
		super();
		this.id = id;
		this.employee_name = employee_name;
		this.employee_lastname = employee_lastname;
		this.employee_username = employee_username;
		this.employee_role = employee_role;
		this.finanacial_year = finanacial_year;
		this.decleration_status = decleration_status;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.rent_amount = rent_amount;
		this.rent_amount_yearly = rent_amount_yearly;
		this.description = description;
	}
	

	@Override
	public String toString() {
		return "Employee [id=" + id + ", employee_name=" + employee_name + ", employee_lastname=" + employee_lastname
				+ ", employee_username=" + employee_username + ", employee_role=" + employee_role + ", finanacial_year="
				+ finanacial_year + ", decleration_status=" + decleration_status + ", decleration_date="
				+ decleration_date + ", address=" + address + ", city=" + city + ", state=" + state + ", pincode="
				+ pincode + ", rent_amount=" + rent_amount + ", rent_amount_yearly=" + rent_amount_yearly
				+ ", description=" + description + "]";
	}

	public Employee() {
	}
	
	
	
	
	

}
