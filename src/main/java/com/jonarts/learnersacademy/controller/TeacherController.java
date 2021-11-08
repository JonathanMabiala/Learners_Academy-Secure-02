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
import com.jonarts.learnersacademy.entity.Teacher;
import com.jonarts.learnersacademy.service.TeacherService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	
	@Autowired
	private TeacherService teacherService;
	
	
	@RequestMapping("/show_teachers")
	public String showTeacher(Model theModel) {
		
		List<Teacher> theTeachers =  teacherService.getTeachers();
		
		theModel.addAttribute("teachers",theTeachers);
		return "teacher-list";
		
	}
	

	@GetMapping("/show_add_form")
	public String showAddForm(Model theModel) {
		
		// Create a new Student Object
		Teacher theTeacher = new Teacher();
		
		// Add the object in the model object
		
		theModel.addAttribute("tempTeacher", theTeacher);
		
		return "teacher-form";
		
	}

	@PostMapping("/save_teacher")
	public String saveStudent(@ModelAttribute("tempTeacher") Teacher theTeacher) {
		
		// Save the Student object with the Service object
		System.out.println(theTeacher);
		teacherService.saveTeacher(theTeacher);
		
		return "redirect:/teacher/show_teachers";

	}
	
	@RequestMapping("/update")
	public String update(@ModelAttribute("teacherId") int theId, Model theModel) {
		
		//Get a Subject by Id
		Teacher theTeacher = teacherService.getTeacherById(theId);
		
		//Assign the subject to a model
		
		theModel.addAttribute("tempTeacher",theTeacher);
		
		return "teacher-form";
		
	}
	
	@GetMapping("/delete")
	public String deleteSubject(@RequestParam("teacherId") int theId, Model theModel) {
		
		//Delete the subject
		teacherService.deleteTeacher(theId);
		
		return "redirect:/teacher/show_teachers";
	}
	
}
