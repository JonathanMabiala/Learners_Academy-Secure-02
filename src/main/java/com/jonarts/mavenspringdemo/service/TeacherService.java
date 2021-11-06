package com.jonarts.mavenspringdemo.service;

import java.util.List;

import com.jonarts.mavenspringdemo.entity.Teacher;

public interface TeacherService {

	public List<Teacher> getTeachers();

	public void saveTeacher(Teacher theTeacher);

	public Teacher getTeacherById(int id);
}
