package com.jonarts.mavenspringdemo.form;

import java.util.LinkedHashMap;
import java.util.List;

import com.jonarts.mavenspringdemo.entity.Course;
import com.jonarts.mavenspringdemo.entity.Subject;
import com.jonarts.mavenspringdemo.entity.Teacher;

public class TeacherSubjectForm {

	private String courseTitle;
	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	private Teacher teacher;
	private Subject subject;
	
	
	
	private LinkedHashMap<Teacher , String> teacherOptions;
	private LinkedHashMap<Subject , String> courseSubjectOptions;
	
	
	public TeacherSubjectForm() {
		
	}
	
	public TeacherSubjectForm(List <Teacher> theTeachers, Course course) {
		
		courseTitle = course.getTitle();
		teacherOptions = new LinkedHashMap<>();
		courseSubjectOptions = new LinkedHashMap<>();
		
		for(Teacher theTeacher : theTeachers) {
			teacherOptions.put(theTeacher, theTeacher.getFirstName() + " " + theTeacher.getLastName());
		}
		
		for (Subject theSubject : course.getSubjects()) {
			courseSubjectOptions.put(theSubject, theSubject.getTitle());
		}
		
	}

	
	

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public LinkedHashMap<Teacher, String> getTeacherOptions() {
		return teacherOptions;
	}

	public void setTeacherOptions(LinkedHashMap<Teacher, String> teacherOptions) {
		this.teacherOptions = teacherOptions;
	}

	public LinkedHashMap<Subject, String> getCourseSubjectOptions() {
		return courseSubjectOptions;
	}

	public void setCourseSubjectOptions(LinkedHashMap<Subject, String> courseSubjectOptions) {
		this.courseSubjectOptions = courseSubjectOptions;
	}

	
	@Override
	public String toString() {
		return "TeacherSubjectForm [courseTitle=" + courseTitle + ", teacher=" + teacher + ", subject=" + subject
				+ ", teacherOptions=" + teacherOptions + ", courseSubjectOptions=" + courseSubjectOptions + "]";
	}


	
	
	
	
	
	
	
	
}
