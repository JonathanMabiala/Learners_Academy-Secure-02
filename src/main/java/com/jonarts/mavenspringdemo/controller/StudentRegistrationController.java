package com.jonarts.mavenspringdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jonarts.mavenspringdemo.entity.Course;
import com.jonarts.mavenspringdemo.entity.Student;
import com.jonarts.mavenspringdemo.form.StudentRegistrationForm;
import com.jonarts.mavenspringdemo.service.CourseService;
import com.jonarts.mavenspringdemo.service.StudentService;

@Controller
@RequestMapping("/registration")
public class StudentRegistrationController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private CourseService courseService;
	
	
	@RequestMapping("/student_registration")
	public String registerStudentToCourse(Model theModel){
		
		List <Student> theStudents = studentService.getStudents();
		
		List <Course> theCourses = courseService.getCourses();
		
		StudentRegistrationForm theStudentForm = new StudentRegistrationForm(theStudents,theCourses);
		
		theModel.addAttribute("theStudentForm",theStudentForm);
		
		return "student-registration";
	}
	
	@RequestMapping("/save")
	public String saveStudentToCourse(@ModelAttribute("theStudentForm") StudentRegistrationForm theStudentForm ){
		
		//Get the student object from the object
		Student theStudent = studentService.getStudentById(theStudentForm.getStudentName());
		Course  theCourse  = courseService.getCourseById(theStudentForm.getCourseTitle());
		
		theStudent.addCourse(theCourse);
		
		studentService.saveStudent(theStudent);
		
		//courseService.saveCourse(theCourse);
	
		
		return "student-registration";
	}

}
