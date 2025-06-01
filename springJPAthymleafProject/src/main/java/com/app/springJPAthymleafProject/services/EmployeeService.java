package com.app.springJPAthymleafProject.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.springJPAthymleafProject.entity.Employee;

public interface EmployeeService extends JpaRepository<Employee, Integer>{

}
