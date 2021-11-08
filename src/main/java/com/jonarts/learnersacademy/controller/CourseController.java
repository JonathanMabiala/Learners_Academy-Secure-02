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

import com.jonarts.learnersacademy.entity.Course;
import com.jonarts.learnersacademy.entity.Student;
import com.jonarts.learnersacademy.entity.Subject;
import com.jonarts.learnersacademy.entity.Teacher;
import com.jonarts.learnersacademy.form.TeacherSubjectForm;
import com.jonarts.learnersacademy.service.CourseService;
import com.jonarts.learnersacademy.service.StudentService;
import com.jonarts.learnersacademy.service.SubjectService;
import com.jonarts.learnersacademy.service.TeacherService;


@Controller
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@Autowired
	private TeacherService teacherService;
	
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private StudentService studentService;
	
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
		
		Course theForm = new Course();
		
		
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
	public String saveCourse(@ModelAttribute("theForm") Course course) {
		
		 courseService.saveCourse(course);
		
		return "redirect:/course/show_courses";
		
	}
	
	@GetMapping("/show_form_for_update")
	public String showFormForUpdate(@RequestParam("courseId") int theId, Model theModel) {
		
		//Get the course from our Service
		
		Course currentCourse = courseService.getCourseById(theId);
	
		
		theModel.addAttribute("theForm",currentCourse);
		
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
		
		
		//System.out.println(theForm.getSubject());
		
		theModel.addAttribute("theForm", theForm);
		
		
		return "manage-course";
	}
	
	@RequestMapping ("/assign_teacher")
	public String assignTeacher(@ModelAttribute("theForm") TeacherSubjectForm theForm, Model theModel) {
		
		//Get the subject id 
		int subjectId = theForm.getSubject();
		//Get Teacher id 
		int teacherId = theForm.getTeacher();
		
		//Get the subject by its id
		Subject theSubject = subjectService.getSubjectById(subjectId);
		//Get the Teacher by Id
		Teacher theTeacher = teacherService.getTeacherById(teacherId);
		
		theSubject.setTeacher(theTeacher);
		
		subjectService.saveSubject(theSubject);
		
		
		return "redirect:/course/show_courses";
	}
	
	@RequestMapping ("/report")
	public String courseReport(@RequestParam("courseId") int theId, Model theModel) {
		
		//Get the course from our Service
		Course currentCourse = courseService.getCourseById(theId);
		
		//Get course subjects
		List<Subject> theSubjects = currentCourse.getSubjects();
		
		//Get course students
		List <Student> theStudents = studentService.getStudentByCourse(theId);
		
		//Add the subjects to the model
		theModel.addAttribute("theSubjects",theSubjects);
		
		//Add the students to the model
		theModel.addAttribute("theStudents",theStudents);
		
		//System.out.println(theStudents);
		
		//Add the Course Object
		theModel.addAttribute("course",currentCourse);
		
		
		return "course-report";
	}
	
	@GetMapping("/delete")
	public String deleteCourse(@RequestParam("courseId") int theId, Model theModel) {
		
		//Delete the customer
		courseService.deleteCourse(theId);
		
		return "redirect:/course/show_courses";
	}
	
}
