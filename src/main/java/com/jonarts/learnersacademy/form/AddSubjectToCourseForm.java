package com.jonarts.learnersacademy.form;

import java.util.LinkedHashMap;
import java.util.List;

import com.jonarts.learnersacademy.entity.Course;
import com.jonarts.learnersacademy.entity.Subject;

public class AddSubjectToCourseForm {
	
	private int subjectId;
	private int courseId;
	
	private String subjectTitle;
	private String courseTitle;
	
	private LinkedHashMap<Integer, String> subjectOptions;
	private LinkedHashMap<Integer, String> courseOptions;
	
	public AddSubjectToCourseForm() {
						
	}
	public AddSubjectToCourseForm(List<Subject> theSubjects, List <Course> theCourses) {
		
		subjectOptions = new LinkedHashMap<>();
		courseOptions = new LinkedHashMap<>();
		
		//Add the subjects to the list
		for(Subject theSubject: theSubjects) {
			
			subjectOptions.put(theSubject.getId(),theSubject.getTitle());
		}
		
		//Add Courses to the hash map
		for(Course theCourse: theCourses) {
			
			courseOptions.put(theCourse.getId(),theCourse.getTitle());
		}
						
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getSubjectTitle() {
		return subjectTitle;
	}
	public void setSubjectTitle(String subjectTitle) {
		this.subjectTitle = subjectTitle;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public LinkedHashMap<Integer, String> getSubjectOptions() {
		return subjectOptions;
	}
	public void setSubjectOptions(LinkedHashMap<Integer, String> subjectOptions) {
		this.subjectOptions = subjectOptions;
	}
	public LinkedHashMap<Integer, String> getCourseOptions() {
		return courseOptions;
	}
	public void setCourseOptions(LinkedHashMap<Integer, String> courseOptions) {
		this.courseOptions = courseOptions;
	}
	
	
	@Override
	public String toString() {
		return "AddSubjectToCourseForm [subjectId=" + subjectId + ", courseId=" + courseId + ", subjectTitle="
				+ subjectTitle + ", courseTitle=" + courseTitle + ", subjectOptions=" + subjectOptions
				+ ", courseOptions=" + courseOptions + "]";
	}
	
	
	
	
	

}
