package com.jonarts.learnersacademy.dao;

import java.util.List;

import com.jonarts.learnersacademy.entity.Student;

public interface StudentDAO {

	public List<Student> getStudent();

	public void saveStudent(Student theStudent);

	public Student getStudentById(int theId);

	public List<Student> getStudentByCourse(int theId);

	public void deleteStudent(int theId);
}
