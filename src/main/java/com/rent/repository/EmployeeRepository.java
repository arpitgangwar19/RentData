package com.rent.repository;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.rent.model.Employee;
import com.rent.util.HibernateUtil;
@Service
public class EmployeeRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	@Transactional
	public void creatEmployee(Employee emp) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(emp);
		session.close();
	}
//	@Transactional
//	public void createEmployee(LoginCredentials cred) {
//		// TODO Auto-generated method stub
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		session.beginTransaction();
//		session.saveOrUpdate(cred);
//		session.close();
//		
//	}
//	
	

}
