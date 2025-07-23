package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Employee;
import com.app.services.EmpService;

@RestController
public class EmployeeController {

	@Autowired
	private EmpService repo;
	
	@PostMapping("/save")
	public String save(@RequestBody Employee e) {
		repo.save(e);
		return "redirect:/";
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		repo.deleteById(id);
		return "redirect:/";
		
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute Employee e) {
		repo.save(e);
		return "update";
	}
}

