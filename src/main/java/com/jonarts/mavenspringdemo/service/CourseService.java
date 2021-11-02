package com.jonarts.mavenspringdemo.service;

import java.util.List;

import com.jonarts.mavenspringdemo.entity.Course;

public interface CourseService {
	
	public List<Course> getCourses();

	public void saveCourse(Course theCourse);

}
