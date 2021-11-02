package com.jonarts.mavenspringdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jonarts.mavenspringdemo.dao.SubjectDAO;
import com.jonarts.mavenspringdemo.entity.Subject;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectDAO subjectDAO;
	
	@Override
	@Transactional
	public List<Subject> getSubjects() {
		
		return subjectDAO.getSubjects();
	}

	@Override
	@Transactional
	public void saveSubject(Subject theSubject) {
		
		subjectDAO.saveSubject(theSubject);
		
	}

}
