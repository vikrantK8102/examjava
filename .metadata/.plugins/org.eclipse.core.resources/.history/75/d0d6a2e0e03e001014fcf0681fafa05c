package com.app.SpringDataJPADemo.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.SpringDataJPADemo.entity.Employee;

public interface EmployeeService extends JpaRepository<Employee, Integer> {

	Employee save(Employee e);

	List<Employee> findAll();

}
