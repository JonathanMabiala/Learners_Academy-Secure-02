package com.jonarts.mavenspringdemo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="hours")
	private int hours;
	
	@OneToMany(mappedBy="course", cascade= {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	private List<Student> students;
	
	@ManyToMany(fetch=FetchType.LAZY,cascade= {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinTable(name="course_teacher",
			joinColumns=@JoinColumn(name="course_id"),
			inverseJoinColumns = @JoinColumn(name="teacher_id")
			)
	private List<Teacher> teachers;
	
	@ManyToMany(fetch=FetchType.LAZY,cascade= {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinTable(name="subject_course",
			joinColumns=@JoinColumn(name="course_id"),
			inverseJoinColumns = @JoinColumn(name="subject_id")
			)
	private List<Subject> subjects;
	
	public Course() {
		
	}
	
	public Course(String title, int hours) {
		this.title = title;
		this.hours = hours;
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

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", hours=" + hours + ", students=" + students + ", teachers="
				+ teachers + ", subjects=" + subjects + "]";
	}
	
	


}
