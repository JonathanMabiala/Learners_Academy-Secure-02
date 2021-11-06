package com.jonarts.mavenspringdemo.dao;

import java.util.List;

import com.jonarts.mavenspringdemo.entity.Teacher;
import com.jonarts.mavenspringdemo.service.TeacherService;

public interface TeacherDAO {

	public List<Teacher> getTeachers();

	public void saveTeacher(Teacher theTeacher);

	public Teacher getTeacherById(int id);
}
