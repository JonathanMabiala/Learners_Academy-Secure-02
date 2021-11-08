package com.jonarts.learnersacademy.dao;

import java.util.List;

import com.jonarts.learnersacademy.entity.Subject;

public interface SubjectDAO {
	
	public List<Subject> getSubjects();
	public void saveSubject(Subject theSubject);
	public Subject getSubjectById(int subjectId);
	public void deleteSubject(int theId);

}
