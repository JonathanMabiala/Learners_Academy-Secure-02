package com.jonarts.mavenspringdemo.dao;

import java.util.List;

import com.jonarts.mavenspringdemo.entity.Course;

public interface CourseDAO {

	public List<Course> getCourses();

	public void saveCourse(Course theCourse);

	public Course getCourseById(int theId);
	
	public int getJoinTableId(int theId);
}
