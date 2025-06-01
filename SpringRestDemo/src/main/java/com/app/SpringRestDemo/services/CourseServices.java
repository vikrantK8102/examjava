package com.app.SpringRestDemo.services;

import java.util.List;

import com.app.SpringRestDemo.entity.Course;

public interface CourseServices {

	public List<Course> getCourses();

	public Course getCourse(Long courseId);

	public Course addCourse(Course cou);

	public Course updateCourse(Course cou);
	
	
}
