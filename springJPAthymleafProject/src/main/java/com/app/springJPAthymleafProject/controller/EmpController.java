package com.app.springJPAthymleafProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.springJPAthymleafProject.entity.Employee;
import com.app.springJPAthymleafProject.services.EmployeeService;

@RestController

public class EmpController {
 
	@Autowired
	private EmployeeService repo;
	
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
	
	@GetMapping("/edit/{id}")
	public String editForm(@PathVariable int id,Model model) {
		model.addAttribute("employee",repo.findById(id).get());
		return "edit";
	}
	
	
	@PostMapping("/update")
	public String update(@ModelAttribute Employee e) {
		repo.save(e);
		return "update";
	}
}
