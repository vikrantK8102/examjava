package com.app.SpringDataJPADemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.SpringDataJPADemo.entity.Employee;
import com.app.SpringDataJPADemo.services.EmployeeService;

@RestController
@RequestMapping("/api/employees/")
public class EmpController {

	@Autowired
	private EmployeeService repository;
	
	@PostMapping
	public Employee addEmp(@RequestBody Employee e) {
		return repository.save(e);
	}
	
	@GetMapping
	public List<Employee> getAllEmp() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Employee> getEmpById(@PathVariable int id) {
		return repository.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmp(@PathVariable int id) {
		repository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Employee updateEmp(@PathVariable int id, @RequestBody Employee e) {
		e.setId(id);
		return repository.save(e);
	}
	
	@GetMapping("/{id}/exists")
	public boolean ifExistEmp(@PathVariable int id) {
		return repository.existsById(id);
	}
}
