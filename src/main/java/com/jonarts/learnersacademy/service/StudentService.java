package com.jonarts.learnersacademy.service;

import java.util.List;

import com.jonarts.learnersacademy.entity.Student;

public interface StudentService {

	public List<Student> getStudents();

	public void saveStudent(Student theStudent);

	public Student getStudentById(int theId);

	public List<Student> getStudentByCourse(int theId);

	public void deleteStudent(int theId);

	public List<Student> getStudentWithNullCourseId();

	
}
