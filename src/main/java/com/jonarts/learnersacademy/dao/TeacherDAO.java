package com.jonarts.learnersacademy.dao;

import java.util.List;

import com.jonarts.learnersacademy.entity.Teacher;
import com.jonarts.learnersacademy.service.TeacherService;

public interface TeacherDAO {

	public List<Teacher> getTeachers();

	public void saveTeacher(Teacher theTeacher);

	public Teacher getTeacherById(int id);

	public void deleteTeacher(int theId);
}
