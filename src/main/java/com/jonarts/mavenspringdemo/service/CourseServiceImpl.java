package com.jonarts.mavenspringdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jonarts.mavenspringdemo.dao.CourseDAO;
import com.jonarts.mavenspringdemo.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDAO courseDAO;
	
	@Override
	@Transactional
	public List<Course> getCourses() {
		return courseDAO.getCourses();
		
	}

	@Override
	@Transactional
	public void saveCourse(Course theCourse) {
		courseDAO.saveCourse(theCourse);
		
	}

}
