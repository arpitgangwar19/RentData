package com.rent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.rent.model.Employee;
import com.rent.model.LoginCredentials;
@Service
@RepositoryDefinition(domainClass = LoginCredentials.class, idClass = Long.class)
public interface EmployeeRepositoryLogin extends JpaRepository<LoginCredentials	, Long>{

	
	
//	@Query("SELECT * FROM login_credential  WHERE employee_username = :employee_username")
//	LoginCredentials findByUsername(@Param("employee_username") String employee_username); 
//	        
	
//	public static final String FIND_PROJECTS = "SELECT * FROM login_credential where username=";
//	
////	 List<Employee> findByName(String name);
////	Employee findemployee_uername(String username);
//	@Query(value = FIND_PROJECTS, nativeQuery = true)
//   LoginCredentials findemployee(String username);
//	
	
	
	
	
	@Query(value="select * from login_credential u where u.employee_username =:userId", nativeQuery=true)
	LoginCredentials getByUsername(@Param("userId") String userId);
}
