package com.jonarts.learnersacademy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jonarts.learnersacademy.dao.SubjectDAO;
import com.jonarts.learnersacademy.entity.Subject;

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

	@Override
	@Transactional
	public Subject getSubjectById(int subjectId) {
		// TODO Auto-generated method stub
		return subjectDAO.getSubjectById(subjectId);
	}

	@Override
	@Transactional
	public void deleteSubject(int theId) {
		subjectDAO.deleteSubject(theId);
		
	}

}
