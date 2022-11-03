package com.ct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ct.entity.Course;
import com.ct.service.CourseService;

@RestController
public class CourseController {

	
	@GetMapping("/home")
	public String home() {
		return "Hello viewers!!";
	}

	@Autowired
	private CourseService courseService;

	// get all courses
	@GetMapping("/courses")
	public List<Course> getCources() {
		return this.courseService.getCourses();
	}

	// return single course based on id
	@GetMapping("/course/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.courseService.getCourse(Long.parseLong(courseId));
	}

	//add a course
	@PostMapping("/courses") // @PostMapping(path= "/courses", consumes= "application/json") //it will
								// consume in json format only if added like this
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
	}
	
	//update course using PUT request
	@PutMapping("/course")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseService.updateCourse(course);
	}
	
	//delete the course 
	@DeleteMapping("/course/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
