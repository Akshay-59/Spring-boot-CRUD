package com.ct.service;

import java.util.List;

import com.ct.entity.Course;

public interface CourseService {
	
	public List<Course> getCources();
	
	public Course getCourse(long courseId);
	
	public Course addCourse(Course course);
	
	public Course updateCourse(Course course);
	
	public void deleteCourse(long parseLong);
	
}
