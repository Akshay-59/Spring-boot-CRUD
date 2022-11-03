package com.ct.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ct.entity.Course;

//course is the class/ entity and Long is the data type of the primary key
@Repository
public interface CourseDao extends JpaRepository<Course, Long>{

	
}
