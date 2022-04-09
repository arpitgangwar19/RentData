package com.rent.dao;


//import com.rent.model.LoginCredentials;

public class EmployeeRequestModel {

	
	
	

	private int id;
	
	private String employee_name;
	
	private String employee_lastname;
	

private	String employee_username;

private String employee_password;
	
private String employee_role;
private	String finanacial_year;
	
private	String decleration_status;

private String decleration_date;
	
private String address;
	
private	String city;
	
private String state;
	
private String pincode;
	
private String rent_amount;
	
private String rent_amount_yearly;
	
public String getEditFormButton() {
	return editFormButton;
}



public void setEditFormButton(String editFormButton) {
	this.editFormButton = editFormButton;
}



private String description;

private String editFormButton;

public EmployeeRequestModel() {
	super();
}



//@OneToOne(fetch = FetchType.LAZY,cascade =  CascadeType.ALL,mappedBy = "employee")
//@Column(name="login_cred_id")
//LoginCredentials  login_cred_id;




public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getEmployee_name() {
	return employee_name;
}

public void setEmployee_name(String employee_name) {
	this.employee_name = employee_name;
}

public String getDecleration_date() {
	return decleration_date;
}



public void setDecleration_date(String decleration_date) {
	this.decleration_date = decleration_date;
}



public String getEmployee_lastname() {
	return employee_lastname;
}

public void setEmployee_lastname(String employee_lastname) {
	this.employee_lastname = employee_lastname;
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



public EmployeeRequestModel(int id, String employee_name, String employee_lastname, String employee_username,
		String employee_password, String employee_role, String finanacial_year, String decleration_status,
		String address, String city, String state, String pincode, String rent_amount, String rent_amount_yearly,
		String description) {
	super();
	this.id = id;
	this.employee_name = employee_name;
	this.employee_lastname = employee_lastname;
	this.employee_username = employee_username;
	this.employee_password = employee_password;
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



public String getEmployee_role() {
	return employee_role;
}



public void setEmployee_role(String employee_role) {
	this.employee_role = employee_role;
}






}
