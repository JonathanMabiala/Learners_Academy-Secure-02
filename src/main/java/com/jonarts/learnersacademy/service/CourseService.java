package com.jonarts.learnersacademy.service;

import java.util.List;

import com.jonarts.learnersacademy.entity.Course;

public interface CourseService {
	
	public List<Course> getCourses();

	public void saveCourse(Course theCourse);

	public Course getCourseById(int theId);
	
	public int getJoinTableId(int theId);

	public void deleteCourse(int theId);

}
