package com.jonarts.mavenspringdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jonarts.mavenspringdemo.entity.Teacher;
import com.jonarts.mavenspringdemo.service.TeacherService;

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
		
		teacherService.saveTeacher(theTeacher);
		
		return "redirect:/teacher/show_teachers";

}
	
}
