package com.app.dao;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entity.Employee;
import com.app.util.HibernateUtil;

public class EmployeeDao {

	public static void saveEmp(Employee e) {
		Session s1 = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s1.beginTransaction();
		s1.save(e);
		tx.commit();
		s1.close();
		
	}
	
	public  List<Employee> getAll(){
		Session s1 = HibernateUtil.getSessionFactory().openSession();
		List<Employee> list = s1.createQuery("from Employee",Employee.class).list();
		s1.close();
		return list;
	}
	
	public void deleteEmp(int id) {
		Session s1 = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s1.beginTransaction();
		Employee em = s1.get(Employee.class,id);
		s1.delete(em);
		tx.commit();
		s1.close();
	}
}
