package com.jonarts.learnersacademy.service;

import java.util.List;

import com.jonarts.learnersacademy.entity.Teacher;

public interface TeacherService {

	public List<Teacher> getTeachers();

	public void saveTeacher(Teacher theTeacher);

	public Teacher getTeacherById(int id);

	public void deleteTeacher(int theId);
}
