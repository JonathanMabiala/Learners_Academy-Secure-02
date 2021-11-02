package com.jonarts.mavenspringdemo.service;

import java.util.List;

import com.jonarts.mavenspringdemo.entity.Subject;

public interface SubjectService {
	
	public List<Subject> getSubjects();

	public void saveSubject(Subject theSubject);

}
