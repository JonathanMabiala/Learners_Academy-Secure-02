package com.jonarts.learnersacademy.form;

import java.util.LinkedHashMap;
import java.util.List;

import com.jonarts.learnersacademy.entity.Course;
import com.jonarts.learnersacademy.entity.Subject;
import com.jonarts.learnersacademy.entity.Teacher;

public class TeacherSubjectForm {

	private String courseTitle;
	private int teacher;
	private int subject;
	
	
	
	private LinkedHashMap<Integer , String> teacherOptions;
	private LinkedHashMap<Integer , String> courseSubjectOptions;
	
	
	public TeacherSubjectForm() {
		
	}
	
	public TeacherSubjectForm(List <Teacher> theTeachers, Course course) {
		
		courseTitle = course.getTitle();
		teacherOptions = new LinkedHashMap<>();
		courseSubjectOptions = new LinkedHashMap<>();
		
		for(Teacher theTeacher : theTeachers) {
			teacherOptions.put(theTeacher.getId(), theTeacher.getFirstName() + " " + theTeacher.getLastName());
		}
		
		for (Subject theSubject : course.getSubjects()) {
			courseSubjectOptions.put(theSubject.getId(), theSubject.getTitle());
		}
		
	}

	
	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public int getTeacher() {
		return teacher;
	}

	public void setTeacher(int teacher) {
		this.teacher = teacher;
	}

	public int getSubject() {
		return subject;
	}

	public void setSubject(int subject) {
		this.subject = subject;
	}

	public LinkedHashMap<Integer, String> getTeacherOptions() {
		return teacherOptions;
	}

	public void setTeacherOptions(LinkedHashMap<Integer, String> teacherOptions) {
		this.teacherOptions = teacherOptions;
	}

	public LinkedHashMap<Integer, String> getCourseSubjectOptions() {
		return courseSubjectOptions;
	}

	public void setCourseSubjectOptions(LinkedHashMap<Integer, String> courseSubjectOptions) {
		this.courseSubjectOptions = courseSubjectOptions;
	}

	
	
	
	@Override
	public String toString() {
		return "TeacherSubjectForm [courseTitle=" + courseTitle + ", teacher=" + teacher + ", subject=" + subject
				+ ", teacherOptions=" + teacherOptions + ", courseSubjectOptions=" + courseSubjectOptions + "]";
	}


	
	
	
	
	
	
	
	
}
