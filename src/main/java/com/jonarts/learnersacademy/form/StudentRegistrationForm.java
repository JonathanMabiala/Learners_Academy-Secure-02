package com.jonarts.learnersacademy.form;

import java.util.LinkedHashMap;
import java.util.List;

import com.jonarts.learnersacademy.entity.Course;
import com.jonarts.learnersacademy.entity.Student;

public class StudentRegistrationForm {
	
	private int studentName;
	private LinkedHashMap<Integer, String> studentOptions;
	
	private int courseTitle;
	
	private LinkedHashMap<Integer, String> courseOptions;
	
	
	public StudentRegistrationForm() {
		
		
	}
	public StudentRegistrationForm(List<Student>theStudents, List<Course> theCourses) {
		studentOptions = new LinkedHashMap<>();
		courseOptions = new LinkedHashMap<>();
		
		//Add Student id and Name to the HasHmap
		for(Student theStudent : theStudents) {
			
			studentOptions.put(theStudent.getId(),theStudent.getFirstName());
		}
		
		//Add Course to the hash map
		for(Course theCourse: theCourses) {
			
			courseOptions.put(theCourse.getId(),theCourse.getTitle());
		}
			
			
	}
	public int getStudentName() {
		return studentName;
	}
	public void setStudentName(int studentName) {
		this.studentName = studentName;
	}
	public LinkedHashMap<Integer, String> getStudentOptions() {
		return studentOptions;
	}
	public void setStudentOptions(LinkedHashMap<Integer, String> studentOptions) {
		this.studentOptions = studentOptions;
	}
	public int getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(int courseTitle) {
		this.courseTitle = courseTitle;
	}
	public LinkedHashMap<Integer, String> getCourseOptions() {
		return courseOptions;
	}
	public void setCourseOptions(LinkedHashMap<Integer, String> courseOptions) {
		this.courseOptions = courseOptions;
	}
	
	

}
