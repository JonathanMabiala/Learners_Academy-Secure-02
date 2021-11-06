package com.jonarts.mavenspringdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jonarts.mavenspringdemo.entity.Course;
import com.jonarts.mavenspringdemo.entity.Subject;
import com.jonarts.mavenspringdemo.form.AddSubjectToCourseForm;
import com.jonarts.mavenspringdemo.service.CourseService;
import com.jonarts.mavenspringdemo.service.SubjectService;

@Controller
@RequestMapping("/subject")
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private CourseService courseService;
	
	
	@RequestMapping("/show_subjects")
	public String showSubjects(Model theModel) {
		
		//Retrieve subject into a list
		List <Subject> theSubjects = subjectService.getSubjects();
		
		
		//Assign the retrieved objects to a Model
		
		theModel.addAttribute("subjects",theSubjects);
		
		return "subject-list";
		
	}
	
	@RequestMapping("/show_add_form")
	public String showAdd(Model theModel) {
		
		//Create a new Subject object
		
		Subject theSubject = new Subject();
		
		//Assign the object to a model
		
		theModel.addAttribute("tempSubject",theSubject);
		
		return "subject-form";
		
	}
	
	@RequestMapping("/update")
	public String update(@ModelAttribute("subjectsId") int theId, Model theModel) {
		
		//Get a Subject by Id
		Subject theSubject = subjectService.getSubjectById(theId);
		
		//Assign the subject to a model
		
		theModel.addAttribute("tempSubject",theSubject);
		
		return "subject-form";
		
	}
	
	@RequestMapping("/save_subject")
	public String addSubjects(@ModelAttribute("tempSubject") Subject theSubject) {
		
		//Save the subject
		
		subjectService.saveSubject(theSubject);
		
		return "redirect:/subject/show_subjects";
		
	}
	
	
	@RequestMapping("/add_subject_to_course")
	public String addSubjectsToCourse(Model theModel) {
		
		//Get the subject list
		List <Subject> theSubjects = subjectService.getSubjects();
		
		//Get the Courses list
		List <Course> theCourses = courseService.getCourses();
		
		//Create the AddSubjectToCourseForm class that acts as container for both the Subject and Course classes
		AddSubjectToCourseForm theForm = new AddSubjectToCourseForm(theSubjects, theCourses);
		
		//Pass the container to the Model object
		theModel.addAttribute("theForm",theForm);
		
		return "add-subject-to-course";
		
	}
	
	@RequestMapping("/save_subject_to_course")
	public String saveSubjectToCourse(@ModelAttribute("theForm") AddSubjectToCourseForm theForm) {
		
		//retrieve the Respective id from the theForm object
		
		//subject id
		int subjectId = theForm.getSubjectId();
		
		//Course id 
		int courseId = theForm.getCourseId();
		
		//Print all the Id
		
		System.out.println("Subject: " + subjectId);
		System.out.println("Course: " + courseId);
		
	
		//Get a Subject by Id
		Subject theSubject = subjectService.getSubjectById(subjectId);
		
		//Get Course by Id
		Course theCourse = courseService.getCourseById(courseId);

		theCourse.addSubject(theSubject);
		
		courseService.saveCourse(theCourse);
		
				
		
		return "add-subject-to-course";
		
	}

}
