package com.jonarts.mavenspringdemo.dao;

import java.util.List;

import org.springframework.ui.Model;

import com.jonarts.mavenspringdemo.entity.Subject;

public interface SubjectDAO {
	
	public List<Subject> getSubjects();
	public void saveSubject(Subject theSubject);

}
