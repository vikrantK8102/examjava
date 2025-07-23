package com.app.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Employee;

public interface EmpService extends JpaRepository<Employee, Integer>{

}
