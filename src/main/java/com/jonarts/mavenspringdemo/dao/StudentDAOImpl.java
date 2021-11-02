package com.jonarts.mavenspringdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jonarts.mavenspringdemo.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Student> getStudent() {
		
		//Get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Make a query to get all students
		Query <Student> theQuery = currentSession.createQuery("From Student", Student.class);
		
		// Get a list of students
		List <Student> Students = theQuery.getResultList();
		
		return Students;
		
	}


	@Override
	public void saveStudent(Student theStudent) {
		
		//Get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theStudent);
		
	}

}
