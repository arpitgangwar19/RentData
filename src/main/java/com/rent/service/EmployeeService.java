package com.rent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rent.dao.EmployeeRequestModel;
import com.rent.model.Employee;
import com.rent.model.LoginCredentials;
import com.rent.repository.EmployeeJpaRepo;
//import com.rent.model.LoginCredentials;
import com.rent.repository.EmployeeRepository;
import com.rent.repository.EmployeeRepositoryLogin;

@Service
public class EmployeeService {
	
	
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	EmployeeJpaRepo  employeeJpaRepo; 
	
	@Autowired
	EmployeeRepositoryLogin employeeRepositoryLogin; 
	public void createEmployee(EmployeeRequestModel request)
	{
		Employee emp = new Employee();
		LoginCredentials cred =new LoginCredentials();
//		emp.setId(request.getId());
		emp.setEmployee_name(request.getEmployee_name());
		emp.setEmployee_lastname(request.getEmployee_lastname());
		emp.setEmployee_username(request.getEmployee_username());
		
		
		
		
		
		cred.setEmployee_password(request.getEmployee_password());
		cred.setEmployee_username(request.getEmployee_username());
		System.out.print(request.getEmployee_role());
//		System.out.print(request.getEmployee_role().isEmpty());
		if(request.getEmployee_role()==null)
		{
			emp.setEmployee_role("employee");
			cred.setEmployee_role("employee");
		}else {
			emp.setEmployee_role("admin");
			cred.setEmployee_role("admin");
		}
		
		
		employeeJpaRepo.save(emp);
		employeeRepositoryLogin.save(cred);
//		employeeRepository.creatEmployee(emp);
		
//		employeeRepository.createEmployee(cred);
		
		
		
	}
	
	
	
	
public String checkPassword(String username, String password) {
		
	  LoginCredentials user =  employeeRepositoryLogin.getByUsername(username);
		
		if(user==null) {
			
			throw new RuntimeException("User does not exist.");
//			return false;
			
		}
        if(!(user.getEmployee_password().equals(password))){
            throw new RuntimeException("Password mismatch.");
        }
        
         return user.getEmployee_role();
		
	}

public Employee getEmployeeDetails(String username) {
	// TODO Auto-generated method stub
	
System.out.print("bbbb");
System.out.print(employeeJpaRepo.getByUsername(username));
	return employeeJpaRepo.getEmployeeByUsername(username);
//   return employeeJpaRepo.findemployee(username);
//	return employeeJpaRepo.findByUsername(username);
}

	public List<Employee> getDetails(String username) {
		// TODO Auto-generated method stub
		
System.out.print("bbbb");
System.out.print(employeeJpaRepo.getByUsername(username));
		return employeeJpaRepo.getByUsername(username);
//	   return employeeJpaRepo.findemployee(username);
//		return employeeJpaRepo.findByUsername(username);
	}




	public List<Employee> getAllEmployeeDetails() {
		// TODO Auto-generated method stub
		return employeeJpaRepo.findAll();
	}




	public Employee findById(long id) {
		// TODO Auto-generated method stub
		return employeeJpaRepo.findById(id);
	}




	public void updateUser(long id, EmployeeRequestModel request) {
		
		
		System.out.print(id);
		System.out.print(request.getAddress());
 Employee employeerow = employeeJpaRepo.findById(id);
	     
	     System.out.print("adasdasdfasdasFSADF");
//	     System.out.print(studentrow.getName());
	     
	
	     
	     
	        if(employeerow!=null) {
	        	
	        	employeerow.setDecleration_status(request.getEditFormButton());
	        employeerow.setFinanacial_year(request.getFinanacial_year());
	   	     employeerow.setDecleration_date(request.getDecleration_date());
	   	     employeerow.setEmployee_name(request.getEmployee_name());
	   	     employeerow.setAddress(request.getAddress());
	   	     employeerow.setCity(request.getCity());
	   	     employeerow.setState(request.getState());
	   	     employeerow.setPincode(request.getPincode());
	   	     employeerow.setRent_amount(request.getRent_amount());
	   	     employeerow.setRent_amount_yearly(request.getRent_amount_yearly());
	   	     employeerow.setDescription(request.getDescription());
	   	     employeeJpaRepo.save(employeerow);
	   	     
	        }
		
		// TODO Auto-generated method stub
		
	}




	public List<Employee> findEmployeeFilter(EmployeeRequestModel request) {
		// TODO Auto-generated method stub
		
	return 	employeeJpaRepo.getByFilters(request.getId(),request.getDecleration_status(),request.getFinanacial_year(), request.getEmployee_name());
		
		
	}


}
