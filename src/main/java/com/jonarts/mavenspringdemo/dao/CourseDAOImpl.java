package com.jonarts.mavenspringdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jonarts.mavenspringdemo.entity.Course;
import com.jonarts.mavenspringdemo.entity.CourseTeacher;

@Repository
public class CourseDAOImpl implements CourseDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Course> getCourses() {
		
		Session currentSession = sessionFactory.getCurrentSession();

		Query <Course> theQuery = currentSession.createQuery("FROM Course",Course.class);
		
		List<Course> courses = theQuery.getResultList();
		
		return courses;
	}

	@Override
	public void saveCourse(Course theCourse) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theCourse);
	}

	@Override
	public Course getCourseById(int theId) {
		
		//Get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve / read form database using the primary key
		
		Course theCourse = currentSession.get(Course.class,theId);
		
		System.out.println(theCourse.getTeacher(theCourse.getTeachers(), theId));
		
		
		return theCourse;
	}

	@Override
	public int getJoinTableId(int theId) {
		
		
		return 0;
	}

}
