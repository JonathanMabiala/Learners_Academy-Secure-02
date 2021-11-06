package com.jonarts.mavenspringdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jonarts.mavenspringdemo.dao.StudentDAO;
import com.jonarts.mavenspringdemo.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	@Transactional
	public List<Student> getStudents() {
		
		return studentDAO.getStudent();
	}

	@Override
	@Transactional
	public void saveStudent(Student theStudent) {
		studentDAO.saveStudent(theStudent);
		
	}

	@Override
	@Transactional
	public Student getStudentById(int theId) {
		
		return studentDAO.getStudentById(theId);
	}

	

}
