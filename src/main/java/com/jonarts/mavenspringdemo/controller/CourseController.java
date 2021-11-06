package com.jonarts.mavenspringdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jonarts.mavenspringdemo.entity.Course;
import com.jonarts.mavenspringdemo.entity.Teacher;
import com.jonarts.mavenspringdemo.form.TeacherCourseForm;
import com.jonarts.mavenspringdemo.form.TeacherSubjectForm;
import com.jonarts.mavenspringdemo.service.CourseService;
import com.jonarts.mavenspringdemo.service.CourseTeacherService;
import com.jonarts.mavenspringdemo.service.TeacherService;


@Controller
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private CourseTeacherService courseTeacherService;
	
	@RequestMapping("/show_courses")
	public String showCourses(Model theModel) {
		
		//Get the list of Courses
		
		List <Course> theCourses = courseService.getCourses();
		
		
		//Pass the courses in the Model object
		
		theModel.addAttribute("courses",theCourses);
		
		return "course-list";
	}
	
//	@GetMapping("/show_add_form")
//	public String showAddForm(Model theModel) {
//		
//		// Create a new course Object
//		Course theCourse = new Course();
//		
//		//Pre populate with teachers
//		
//		List<Teacher> theTeachers = teacherService.getTeachers();
//		
//		theCourse.setTempTeacher(theTeachers);
//		
//		System.out.println(theCourse.getTempTeacher());
//		// Add the object in the model object
//		
//		theModel.addAttribute("tempCourse", theCourse);
//		
//		
//		return "course-form";
//		
//	}
	
	// Form to add Teacher a teacher to a course
	
	@GetMapping("/show_add_form")
	public String showAddForm(Model theModel) {
		
		
		// Create a new teacherCourse Object to serve as a form
		
		TeacherCourseForm theForm = new TeacherCourseForm(new Course(), new Teacher());
		
		
		theModel.addAttribute("theForm", theForm);
		
		
		return "course-form";
		
	}
	
	
	
//	@GetMapping("/show_add_form")
//	public String showAddForm(ModelMap theModel) {
//		
//		// Create a new teacherCourse Object to serve as a form
//		
//		// Create a new course Object
//		Course theCourse = new Course();
//		
//		// get Teacher Objects
//		List<Teacher> theTeachers =  teacherService.getTeachers();	
//		List <String> tempTeacher = new ArrayList<String>();
//		
//		for(Teacher items : theTeachers) {
//			tempTeacher.add(items.getFirstName());
//		}
//		
//		
//		theModel.addAttribute("theCourse", theCourse);
//		theModel.addAttribute("theTeacher", tempTeacher);
//		
//		
//		return "course-form";
//		
//	}
	
	@PostMapping("/save_course")
	public String saveCourse(@ModelAttribute("theForm") TeacherCourseForm theTeacherCourseForm) {
		
		//Retrieve  Course data from theTeacherCourseForm object
		
		String title = theTeacherCourseForm.getCourseTitle();
		int hours = theTeacherCourseForm.getCourseHours();
		
		//Retrieve  Teacher data from theTeacherCourseForm object
		
		String firstName = theTeacherCourseForm.getTeacherFirstName();
		String lastName = theTeacherCourseForm.getTeacherLastName();
		String email = theTeacherCourseForm.getTeacherEmail();
		
		if(theTeacherCourseForm.getCourseId() != 0) {
			
			System.out.println("Here is the problem!!!!!!!!!!!!!!!");

			//Get teacher id
			int teacherId = courseTeacherService.getId(theTeacherCourseForm.getCourseId());
			
			// The Teacher object from Service
			Teacher currentTeacher = teacherService.getTeacherById(teacherId);
			
			//Get the course form our Service
			
			Course currentCourse = courseService.getCourseById(theTeacherCourseForm.getCourseId());
			
			
			//Set the currentTeacher values 
			 currentTeacher.setFirstName(firstName);
			 currentTeacher.setLastName(lastName);
			 currentTeacher.setEmail(email);
			 
			 teacherService.saveTeacher(currentTeacher);
			
			// Create a course object and Add Teacher to the Course object

			 currentCourse.setTitle(title);
			 currentCourse.setHours(hours);
			// Save the Course object
			 
			 courseService.saveCourse(currentCourse);
			
			//Add a teacher in the course object
		}else {
		
		
	
		//Create and Save theTeacher Object
		 Teacher theTeacher = new Teacher(firstName,lastName,email);

		 teacherService.saveTeacher(theTeacher);
		
		// Create a course object and Add Teacher to the Course object
		 
		 Course theCourse = new Course(title, hours);
 
		 theCourse.add(theTeacher);
		// Save the Course object
		 
		 courseService.saveCourse(theCourse);
		
		}
		
		return "redirect:/course/show_courses";
		
	}
	
	@GetMapping("/show_form_for_update")
	public String showFormForUpdate(@RequestParam("courseId") int theId, Model theModel) {
		
		//Get the course from our Service
		
		Course currentCourse = courseService.getCourseById(theId);
		
		//Get teacher id
		int id = courseTeacherService.getId(theId);
		
		// The Teacher object from Service
		Teacher currentTeacher = teacherService.getTeacherById(id);
	
		
		//set course as a model attribute to pre-populate the form
		
		//Create a courseTeacherForm object
		
		
		
		TeacherCourseForm theForm = new TeacherCourseForm(currentCourse, currentTeacher );
		
		
		
		
		theModel.addAttribute("theForm",theForm);
		
		//send over to our form
		
		
		
		return "course-form";
	}
	
	@RequestMapping ("/manage")
	public String manageCourse(@RequestParam("courseId") int theId, Model theModel) {
		
		//Get the course from our Service
		Course currentCourse = courseService.getCourseById(theId);
		
		//Get the list of all the teachers
		List <Teacher> theTeachers = teacherService.getTeachers();
		
		//Create the TeacherSubejectForm object . It serves as a container
		
		TeacherSubjectForm theForm = new TeacherSubjectForm(theTeachers, currentCourse);
		
		
		System.out.println(theForm.getSubject());
		
		
		return "manage-course";
	}
	
}
