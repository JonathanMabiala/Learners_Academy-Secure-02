package com.jonarts.mavenspringdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jonarts.mavenspringdemo.entity.Subject;

@Repository
public class SubjectDAOImpl implements SubjectDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Subject> getSubjects() {
		
		
		//Get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Make a query
		
		Query <Subject> theQuery = currentSession.createQuery("FROM Subject",Subject.class);
		
		//Get the list of subjects
		
		List <Subject> subjects = theQuery.list();
		
		
		return subjects;
		
	}

	@Override
	public void saveSubject(Subject theSubject) {
		
		//Get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Session save
		currentSession.saveOrUpdate(theSubject);
		
	}

	
}
