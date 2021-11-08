package com.jonarts.learnersacademy.report;

import java.util.ArrayList;

import java.util.List;

import com.jonarts.learnersacademy.entity.Student;
import com.jonarts.learnersacademy.entity.Subject;

public class CourseReport {
	
	private List <String> students;
	private List <Subject>  subjects;
	

	public CourseReport() {
		
	}
	
	public CourseReport(List <Student> theStudents, List<Subject> theSubjects) {
		
		//instantiate an array list for students
		students = new ArrayList<>();
		
		//Instantiate an array list for subjects
		subjects = new ArrayList<>();
		
		//Add students to the array list
		for(Student theStudent : theStudents) {
			students.add(theStudent.getFirstName() + " " + theStudent.getLastName());
		}
		
		//Add subjects to the array list
		for(Subject theSubject : theSubjects) {
			subjects.add(theSubject);
		}
	}
}
