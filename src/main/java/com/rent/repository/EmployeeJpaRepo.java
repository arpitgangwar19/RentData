package com.rent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.rent.model.Employee;
@Service
public interface EmployeeJpaRepo extends JpaRepository<Employee, Long> {
	
	
	
//	public static final String FIND_PROJECTS = "SELECT * FROM employee where username=";
//	
////	 List<Employee> findByName(String name);
////	Employee findemployee_uername(String username);
//	@Query(value = FIND_PROJECTS, nativeQuery = true)
//    Employee findemployee(String username);

	
	
	
	
	@Query(value="select * from Employee u where u.employee_username =:userId", nativeQuery=true)
	List<Employee> getByUsername(@Param("userId") String userId);
	
	Employee findById(long id);
	
	@Query(value="select * from Employee u where u.employee_username =:userId", nativeQuery=true)
	Employee getEmployeeByUsername(@Param("userId") String username);
	
//	
//	@Query(value="SELECT * from Employee e  where e.decleration_status = :decleration_status" + 
//					"SELECT * from Employee e  where e.finanacial_year = :finanacial_year"+
//		            "SELECT * from Employee e  where e.employee_name = :employee_name"+
//					"SELECT * from Employee e  where e.id = :id", nativeQuery=true)
//	List<Employee> getByFilters(@Param("userId") String userId,@Param("userId") String decleration_status,@Param("decleration_status") String finanacial_year,@Param("employee_name") String employee_name);
//	
	
	
//	@Query(value="SELECT * from Employee e  where e.decleration_status = :decleration_status INTERSECT SELECT * from Employee e  where e.finanacial_year = :finanacial_year INTERSECT  SELECT * from Employee e  where e.employee_name = :employee_name INTERSECT SELECT * from Employee e  where e.id = :id", nativeQuery=true)
//List<Employee> getByFilters(@Param("userId") String userId,@Param("userId") String decleration_status,@Param("decleration_status") String finanacial_year,@Param("employee_name") String employee_name);

	@Query(value="select * from employee where id=:userId UNION select * from employee where decleration_status=:decleration_status UNION select * from employee where employee_name=:employee_name UNION select * from employee where finanacial_year=:finanacial_year", nativeQuery=true)
List<Employee> getByFilters(@Param("userId") long userId,@Param("decleration_status") String decleration_status,@Param("finanacial_year") String finanacial_year,@Param("employee_name") String employee_name);

	
}


