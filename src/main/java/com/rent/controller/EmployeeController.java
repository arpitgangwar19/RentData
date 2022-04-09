package com.rent.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.rent.dao.EmployeeRequestModel;
import com.rent.model.AuthenticationRequest;
import com.rent.model.AuthenticationResponse;
import com.rent.model.Employee;
import com.rent.service.EmployeeService;
import com.rent.util.JwtUtil;

@RestController
public class EmployeeController {

	
	
	@Autowired
	EmployeeService employeeService;
	
	
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	UserDetailsService userDetailsService;
	@Autowired
	JwtUtil jwtTokenUtil;
	
    @Autowired
    PasswordEncoder passwordEncoder;
	@GetMapping("/")
	public String employee() {
		
		return "working";
	}
	
	@GetMapping("/authenticate")
	public ModelAndView createtoken() {
			
			ModelAndView model =new ModelAndView();
			model.setViewName("login");
	   return model;		
		}

	@PostMapping("/authenticate")
	public ModelAndView createAuthenticationToken(@ModelAttribute("user") EmployeeRequestModel request, EmployeeRequestModel authenticationReq,HttpServletResponse response) throws Exception {
		
		
//		java.util.List<Student> data = studentService.findByName(authenticationReq.getUsername());
		
//		if(data!=null) {
		
		    
			
			try {
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationReq.getEmployee_username(),authenticationReq.getEmployee_password()));
				} catch(BadCredentialsException e) {
				return new ModelAndView("signup");
				}
				final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationReq.getEmployee_username());
				final String jwt = jwtTokenUtil.generateToken(userDetails);
				
				 Cookie cookie = new Cookie("token", jwt);

				    //add cookie to response
				 cookie.setMaxAge(1000*60*60);
				    response.addCookie(cookie);

				    
				    
				    ModelAndView model = new ModelAndView();
					
					Employee  user = employeeService.getEmployeeDetails(request.getEmployee_username());
					model.addObject("user",user);
					if(employeeService.checkPassword(request.getEmployee_username(),request.getEmployee_password()).equals("admin"))
					{
//						System.out.print(employeeService.getAllEmployeeDetails());
						model.addObject("data", employeeService.getAllEmployeeDetails());	
					}
					else {
						
						
					   model.addObject("data", employeeService.getDetails(request.getEmployee_username()));	
					}
					
					model.setViewName("content");
					return model;
//				return ResponseEntity.ok(new AuthenticationResponse(jwt) );
			
				
				
//		}
//		return ResponseEntity.ok("Not Authorized");
		
		 

	}
	
	@GetMapping("/find")
	public String findemployee() {
		
		return "working";
	}
	@GetMapping("/signup")
	public ModelAndView signup_form() {
		ModelAndView model = new ModelAndView();
		model.setViewName("signup");
		
		return model;
	}
	@PostMapping("/signup")
	public ModelAndView createEmployee(@ModelAttribute("user")  EmployeeRequestModel request) {
		
		employeeService.createEmployee(request);
		
		ModelAndView model = new ModelAndView();
		model.addObject("flag", true);
		model.setViewName("signup");
	
		 return  model;
		
		
	}
	@GetMapping("/signout")
	public ModelAndView logout(HttpServletResponse response) {
	
		
		ModelAndView model = new ModelAndView();
		Cookie cookie = new Cookie("token", null);


		cookie.setMaxAge(0);


//		cookie.setSecure(true);
//
//
//		cookie.setHttpOnly(true);

//		cookie.setPath("/");



		response.addCookie(cookie);
		model.setViewName("login");
	
		 return  model;
		
		
	}
//	@PostMapping("/signup")
//	public void createEmployee( EmployeeRequestModel request) {
//		
//		employeeService.createEmployee(request);
//		
////		ModelAndView model = new ModelAndView();
////		model.addObject("flag", true);
////		model.setViewName("signup");
//	
////		 return  model;
//		
//		
//	}
	
	
	@GetMapping("/login")
	public ModelAndView login_Form() {
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		
		return model;
	}
	@PostMapping("/welcome")
	public ModelAndView login_Check(@ModelAttribute("user") EmployeeRequestModel request) {
		ModelAndView model = new ModelAndView();
		
		Employee  user = employeeService.getEmployeeDetails(request.getEmployee_username());
		model.addObject("user",user);
		if(employeeService.checkPassword(request.getEmployee_username(),request.getEmployee_password()).equals("admin"))
		{
//			System.out.print(employeeService.getAllEmployeeDetails());
			model.addObject("data", employeeService.getAllEmployeeDetails());	
		}
		else {
			
			
		   model.addObject("data", employeeService.getDetails(request.getEmployee_username()));	
		}
		
		model.setViewName("content");
		return model;
	}
	
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(
			@PathVariable("id") Long id) {
		Employee data = employeeService.findById(id);
		ModelAndView model = new ModelAndView();
		model.setViewName("editForm");
		model.addObject("lists",data);
		
		return model;
	}
	
	
	@PostMapping("/editSave")
	public ModelAndView editSave(@ModelAttribute("user") EmployeeRequestModel request) {
		
		
//		System.out.print("scasdasca");

		System.out.print(request.getId());
		System.out.print(request.getEditFormButton());
		employeeService.updateUser(request.getId(), request);
//		ModelAndView model = new ModelAndView();
//		model.setViewName("authenticate");
		return new ModelAndView("redirect:/authenticate");
		

	}
	@PostMapping("/testing")
public ResponseEntity<List<Employee>> findemployees(@RequestBody EmployeeRequestModel request) {
		
		List<Employee> data = employeeService.findEmployeeFilter(request);
		System.out.println("testing"+data);
//		return null;
		
		return new ResponseEntity<List<Employee>>(data,HttpStatus.OK);
//		return "working";
	}
	
	

}
