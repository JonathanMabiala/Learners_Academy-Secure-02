package com.jonarts.learnersacademy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jonarts.learnersacademy.entity.Student;
import com.jonarts.learnersacademy.entity.Subject;
import com.jonarts.learnersacademy.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService; 
	
	@RequestMapping("/show_students")
	public String showStudents(Model theModel) {
		
		List<Student> theStudents =  studentService.getStudents();
		
		theModel.addAttribute("students",theStudents);
		return "student-list";
		
	}
	
	@GetMapping("/show_add_form")
	public String showAddForm(Model theModel) {
		
		// Create a new Student Object
		Student theStudent = new Student();
		
		// Add the object in the model object
		
		theModel.addAttribute("tempStudent", theStudent);
		
		return "student-form";
		
	}

	@PostMapping("/save_student")
	public String saveStudent(@ModelAttribute("tempStudent") Student theStudent) {
		
		// Save the Student object with the Service object
		
		studentService.saveStudent(theStudent);
		
		return "redirect:/student/show_students";
		
	}
	
	@RequestMapping("/update")
	public String update(@ModelAttribute("studentId") int theId, Model theModel) {
		
		//Get a Subject by Id
		Student theStudent = studentService.getStudentById(theId);
		
		//Assign the subject to a model
		
		theModel.addAttribute("tempStudent",theStudent);
		
		return "student-form";
		
	}
	
	@GetMapping("/delete")
	public String deleteSubject(@RequestParam("studentId") int theId, Model theModel) {
		
		//Delete the subject
		studentService.deleteStudent(theId);
		
		return "redirect:/student/show_students";
	}

}
