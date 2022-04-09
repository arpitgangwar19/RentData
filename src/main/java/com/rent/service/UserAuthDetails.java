package com.rent.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rent.model.LoginCredentials;
import com.rent.repository.EmployeeJpaRepo;
import com.rent.repository.EmployeeRepositoryLogin;



@Service
public class UserAuthDetails implements  UserDetailsService {
	
     @Autowired
     PasswordEncoder passwordEncoder;
     
     @Autowired
     EmployeeRepositoryLogin  employeeRepositoryLogin; 
     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.print("sddfsdc"+username);
		LoginCredentials user =  employeeRepositoryLogin.getByUsername(username);
		String pass;
		
		if(user!=null)
		{
		pass = user.getEmployee_password();
		
		System.out.print(pass);
		}else {
			System.out.println("Inside else !!!! condition userModelRepository.existsById(username)");
			throw new UsernameNotFoundException(username + "not found!!!!");
			}

	return new User(username,passwordEncoder.encode(pass), new ArrayList<>() );
	}

}





