package com.jonarts.learnersacademy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jonarts.learnersacademy.entity.Student;

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


	@Override
	public Student getStudentById(int theId) {
		
		//Get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// now retrieve / read form database using the primary key
				
		Student theStudent = currentSession.get(Student.class,theId);
		
		return theStudent;
	}


	@Override
	public List<Student> getStudentByCourse(int theId) {
		
		//Get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Get the student by course id
		// Make a query
		Query<Student> theQuery = currentSession.createQuery("FROM Student where course_id=:theId", Student.class);
		theQuery.setParameter("theId", theId);
		List <Student> theStudents = theQuery.getResultList();
		
		
		
		return theStudents;
	}


	@Override
	public void deleteStudent(int theId) {
		
		//Get the current Hibernate session
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		
		Query theQuery = currentSession.createQuery("delete from Student where id=:subjectId");
		
		theQuery.setParameter("subjectId", theId);
		
		theQuery.executeUpdate();
				
		
	}


	@Override
	public List<Student> getStudentWithNullCourseId() {
		
		//Get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Get the student by course id
		// Make a query
		Query<Student> theQuery = currentSession.createQuery("FROM Student where course_id IS NULL", Student.class);
		List <Student> theStudents = theQuery.getResultList();
		
		return theStudents;
	}

}
