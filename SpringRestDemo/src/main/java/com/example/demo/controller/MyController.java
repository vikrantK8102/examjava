package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Course;
import com.example.demo.services.CourseServicesI;

@RestController
public class MyController {

	
	@Autowired
	private CourseServicesI courseSer;
	
	@GetMapping("/Courses")
	public List<Course> getCourses(){
		return this.courseSer.getCourses();
	}

	@GetMapping("/Courses/{courseId}")
	public Course getCourse(@PathVariable Long courseId) {
		return this.courseSer.getCourse(courseId);
		
	}

	@PostMapping("/Courses")
	public Course addCourse(Course cou) {
		return this.courseSer.addCourse(cou);
	}

	@PutMapping("/Courses")
	public Course updateCourse(Course cou) {
		return this.courseSer.updateCourse(cou);
	}
	
	
	
}
