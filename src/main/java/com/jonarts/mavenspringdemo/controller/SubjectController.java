package com.jonarts.mavenspringdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jonarts.mavenspringdemo.entity.Subject;
import com.jonarts.mavenspringdemo.service.SubjectService;

@Controller
@RequestMapping("/subject")
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	
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
	
	@RequestMapping("/save_subject")
	public String addSubjects(@ModelAttribute("tempSubject") Subject theSubject) {
		
		//Save the subject
		
		subjectService.saveSubject(theSubject);
		
		return "redirect:/subject/show_subjects";
		
	}

}
