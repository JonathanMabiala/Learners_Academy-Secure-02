package com.jonarts.learnersacademy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jonarts.learnersacademy.dao.TeacherDAO;
import com.jonarts.learnersacademy.entity.Teacher;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherDAO teacherDAO;
	
	@Override
	@Transactional
	public List<Teacher> getTeachers() {
		
		return teacherDAO.getTeachers();
	}

	@Override
	@Transactional
	public void saveTeacher(Teacher theTeacher) {
		teacherDAO.saveTeacher(theTeacher);
		
	}

	@Override
	@Transactional
	public Teacher getTeacherById(int id) {
		
		return teacherDAO.getTeacherById(id);
	}

	@Override
	@Transactional
	public void deleteTeacher(int theId) {
		teacherDAO.deleteTeacher(theId);
		
	}

}
