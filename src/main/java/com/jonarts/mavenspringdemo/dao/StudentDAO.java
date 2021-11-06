package com.jonarts.mavenspringdemo.dao;

import java.util.List;

import com.jonarts.mavenspringdemo.entity.Student;

public interface StudentDAO {

	public List<Student> getStudent();

	public void saveStudent(Student theStudent);

	public Student getStudentById(int theId);
}
