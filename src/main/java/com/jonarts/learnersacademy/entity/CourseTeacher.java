package com.jonarts.learnersacademy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course_teacher")
public class CourseTeacher {
	
	
	@Id
	@Column(name="course_id")
	private int course_id;
	
	@Column(name="teacher_id")
	private int teacher_id;

	public CourseTeacher() {
	
	}
	
	public CourseTeacher(int course_id, int teacher_id) {
		super();
		this.course_id = course_id;
		this.teacher_id = teacher_id;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	
	
	

	
	
}
