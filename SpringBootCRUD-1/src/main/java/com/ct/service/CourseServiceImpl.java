package com.ct.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ct.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {

	List<Course> list; // create a list to return

	// cretae default constructor and add data into it
	public CourseServiceImpl() {
		list = new ArrayList<>();
		list.add(new Course(121, "Java Core Course", "This couse contains basics od Java"));
		list.add(new Course(131, "Spring Boot Course", "This couse contains Creating REST api"));
		list.add(new Course(141, "Java Core Course", "This couse contains basics od Java"));
		list.add(new Course(151, "Spring Boot Course", "This couse contains Creating REST api"));

	}

	@Override
	public Course getCourse(long courseId) {
		Course c = null;
		for (Course course : list) {
			if (course.getId() == courseId) {
				c = course;
				break;
			}
		}
		return c;
	}

	@Override
	public List<Course> getCources() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		list.forEach(e -> {
			if(e.getId() == course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
			}
			
		});
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
		
		list= this.list.stream().filter(e -> e.getId()!=parseLong).collect(Collectors.toList());
	}

}
