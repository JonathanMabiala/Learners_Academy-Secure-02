package com.jonarts.mavenspringdemo.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="subject")
public class Subject {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinTable(name="subject_course",
			joinColumns=@JoinColumn(name="subject_id"),
			inverseJoinColumns = @JoinColumn(name="course_id")
			)
	private List<Course> courses;
//	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="teacher_id")
	private Teacher teacher;
//	
	
	public Subject() {
		
	}
	

	public Subject(String title) {
		this.title = title;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}




	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}


	public Teacher getTeacher() {
		return teacher;
	}

	
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}


	@Override
	public String toString() {
		return "Subject [id=" + id + ", title=" + title + ", courses=" + courses + ", teacher=" + teacher + "]";
	}
	

}
