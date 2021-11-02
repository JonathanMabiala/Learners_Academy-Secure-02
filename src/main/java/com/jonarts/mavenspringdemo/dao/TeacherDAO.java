package com.jonarts.mavenspringdemo.dao;

import java.util.List;

import com.jonarts.mavenspringdemo.entity.Teacher;

public interface TeacherDAO {

	public List<Teacher> getTeachers();

	public void saveTeacher(Teacher theTeacher);
}
