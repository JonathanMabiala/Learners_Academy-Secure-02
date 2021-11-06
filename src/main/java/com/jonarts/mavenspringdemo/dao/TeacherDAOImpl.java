package com.jonarts.mavenspringdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jonarts.mavenspringdemo.entity.Teacher;

@Repository
public class TeacherDAOImpl implements TeacherDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Teacher> getTeachers() {
		
		//Get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Make a query to get all students
		Query <Teacher> theQuery = currentSession.createQuery("From Teacher", Teacher.class);
		
		// Get a list of students
		List <Teacher> teachers = theQuery.getResultList();
		
		return teachers;
		
	}


	@Override
	public void saveTeacher(Teacher theTeacher) {
		
		//Get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theTeacher);
		
	}


	@Override
	public Teacher getTeacherById(int id) {
		//Get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve / read form database using the primary key
		
		Teacher theTeacher = currentSession.get(Teacher.class,id);
		
		return theTeacher;
	}

}
