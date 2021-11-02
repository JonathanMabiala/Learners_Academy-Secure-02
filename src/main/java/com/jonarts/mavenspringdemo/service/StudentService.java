package com.jonarts.mavenspringdemo.service;

import java.util.List;

import com.jonarts.mavenspringdemo.entity.Student;

public interface StudentService {

	public List<Student> getStudents();

	public void saveStudent(Student theStudent);
}
