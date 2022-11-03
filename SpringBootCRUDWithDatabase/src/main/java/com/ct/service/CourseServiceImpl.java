package com.ct.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.dao.CourseDao;
import com.ct.entity.Course;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseDao courseDao;
	
	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return courseDao.findAll();
	}

	@Override
	public Course getCourse(long courseId) {
		// TODO Auto-generated method stub
		return courseDao.getReferenceById(courseId);    //getOne
	}

	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		courseDao.save(course); // no any for update, can use save method
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
		// TODO Auto-generated method stub
		Course entity= courseDao.getOne(parseLong);
		courseDao.delete(entity);
		
	}
	

}
