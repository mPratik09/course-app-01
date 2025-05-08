package com.course_app_01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.course_app_01.entity.Course;
import com.course_app_01.repo.CourseRepo;

@Controller
public class CourseController
{

	@Autowired
	private CourseRepo courseRepo;

//	@RequestMapping("/courseAdded")
//	public String addSubject(@RequestParam("course_name") String courseName,
//			@RequestParam("description") String desccription)
//	{
//		Course course = new Course();
//		course.setCourse_name(courseName);
//		course.setDescription(desccription);
//		courseRepo.save(course);
//
//		return "addCourse";
//	}

	@RequestMapping("/addCourse")
	public String addSubject(@ModelAttribute Course course)
	{
		return "addCourse";
	}

	@RequestMapping("/courseAdded")
	public String addSubjectPage(@ModelAttribute Course course)
	{

		System.out.println("Course data:\t" + course);
		courseRepo.save(course);

		return "addCourse";
	}

}
