package com.jonarts.learnersacademy.service;

import java.util.List;

import com.jonarts.learnersacademy.entity.Subject;

public interface SubjectService {
	
	public List<Subject> getSubjects();

	public void saveSubject(Subject theSubject);

	public Subject getSubjectById(int subjectId);

	public void deleteSubject(int theId);

}
