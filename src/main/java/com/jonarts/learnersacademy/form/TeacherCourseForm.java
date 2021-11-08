package com.jonarts.learnersacademy.form;

import com.jonarts.learnersacademy.entity.Course;
import com.jonarts.learnersacademy.entity.Teacher;

public class TeacherCourseForm {
	
	private int courseId;
	
	private String teacherFirstName;
	
	private String teacherLastName;
	
	private String teacherEmail;
	
	private String courseTitle;
	
	private int courseHours;
	
	private Course course;
	
	private Teacher teacher;

	public TeacherCourseForm() {
		
	}
	
	public TeacherCourseForm(Course theCourse, Teacher theTeacher) {
		
		this.courseTitle = theCourse.getTitle();
		this.courseHours = theCourse.getHours();
		this.teacherFirstName = theTeacher.getFirstName();
		this.teacherLastName = theTeacher.getLastName();
		this.teacherEmail = theTeacher.getEmail();
		this.courseId = theCourse.getId();
		this.course  = theCourse;
		this.teacher = theTeacher;
		
	}
	
	
	public TeacherCourseForm(String teacherFirstName, String teacherLastName, String teacherEmail, String courseTitle,
			int courseHours) {
		super();
		this.teacherFirstName = teacherFirstName;
		this.teacherLastName = teacherLastName;
		this.teacherEmail = teacherEmail;
		this.courseTitle = courseTitle;
		this.courseHours = courseHours;
	}
	
	public String getTeacherFirstName() {
		return teacherFirstName;
	}
	
	public void setTeacherFirstName(String teacherFirstName) {
		this.teacherFirstName = teacherFirstName;
	}
	
	public String getTeacherLastName() {
		return teacherLastName;
	}
	
	public void setTeacherLastName(String teacherLastName) {
		this.teacherLastName = teacherLastName;
	}
	
	public String getTeacherEmail() {
		return teacherEmail;
	}
	
	public void setTeacherEmail(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	
	public int getCourseHours() {
		return courseHours;
	}
	
	public void setCourseHours(int courseHours) {
		this.courseHours = courseHours;
	}
	
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	@Override
	public String toString() {
		return "TeacherCourseForm [teacherFirstName=" + teacherFirstName + ", teacherLastName=" + teacherLastName
				+ ", teacherEmail=" + teacherEmail + ", courseTitle=" + courseTitle + ", courseHours=" + courseHours
				+ "]";
	}
	
	
	
	
	
	

}
