package com.jonarts.mavenspringdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jonarts.mavenspringdemo.entity.Course;
import com.jonarts.mavenspringdemo.service.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/show_courses")
	public String showCourses(Model theModel) {
		
		//Get the list of Courses
		
		List <Course> theCourses = courseService.getCourses();
		
		//Pass the courses in the Model object
		
		theModel.addAttribute("courses",theCourses);
		
		
		return "show-courses";
	}
	
	@GetMapping("/show_add_form")
	public String showAddForm(Model theModel) {
		
		// Create a new course Object
		Course theCourse = new Course();
		
		// Add the object in the model object
		
		theModel.addAttribute("tempCourse", theCourse);
		
		return "course-form";
		
	}
	
	@PostMapping("/save_course")
	public String saveCourse(@ModelAttribute("tempCourse") Course theCourse) {
		
		courseService.saveCourse(theCourse);
		
		return "redirect:/course/show_courses";
		
	}
	
}
