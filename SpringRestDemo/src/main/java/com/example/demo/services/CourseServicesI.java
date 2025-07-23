package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Course;

public interface CourseServicesI {
	public List<Course> getCourses();

	public Course getCourse(Long courseId);

	public Course addCourse(Course cou);

	public Course updateCourse(Course cou);
	
	
}
