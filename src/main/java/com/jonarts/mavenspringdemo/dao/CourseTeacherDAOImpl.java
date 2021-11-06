package com.jonarts.mavenspringdemo.dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jonarts.mavenspringdemo.entity.CourseTeacher;


@Repository
public class CourseTeacherDAOImpl implements CourseTeacherDAO {

	
	@Autowired
	
	private SessionFactory sessionFactory;
	
	@Override
	public int getId(int theId) {
		
		//Get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve / read form database using the ID
		
		
		CourseTeacher theCourseTeacher = currentSession.get(CourseTeacher.class,theId);
	
		
		return theCourseTeacher.getTeacher_id();
	}

}
