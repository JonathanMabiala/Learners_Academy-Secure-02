package com.jonarts.learnersacademy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jonarts.learnersacademy.dao.CourseTeacherDAO;

@Service
public class CourseTeacherServiceImpl implements CourseTeacherService {

	@Autowired
	
	private CourseTeacherDAO courseTeacherDAO;
	
	@Override
	@Transactional
	public int getId(int theId) {
		
		return courseTeacherDAO.getId(theId);
	}

}
