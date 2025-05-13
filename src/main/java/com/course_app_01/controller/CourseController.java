package com.course_app_01.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.course_app_01.entity.Course;
import com.course_app_01.repo.CourseRepo;

@Controller
public class CourseController
{

	@Autowired
	private CourseRepo courseRepo;

	@RequestMapping("/addCourse")
	public String addSubject()
	{
		return "addCourse";
	}

	@RequestMapping("/courseAdded")
	public String addSubjectPage(@ModelAttribute Course course)
	{
		courseRepo.save(course);
		return "addCourse";
	}

	@RequestMapping("/viewCourses")
	public String viewCourse(@ModelAttribute Course course, ModelMap modelMap)
	{
		List<Course> courseList = courseRepo.findAll();
		modelMap.addAttribute("courseList", courseList);
		return "viewCourses";
	}

	@RequestMapping("/updateCourse")
	public String upadteCourse(@RequestParam("c_id") Long c_id, ModelMap modelMap)
	{
		Optional<Course> courseToBeEdited = courseRepo.findById(c_id);
		Course course = courseToBeEdited.get();
		modelMap.addAttribute("course", course);

		return "editCourse";
	}

	@RequestMapping("/saveUpdatedCourse")
	public String saveUpdatedCourse(@ModelAttribute Course course, ModelMap modelMap)
	{
		courseRepo.save(course);
		List<Course> courseList = courseRepo.findAll();
		modelMap.addAttribute("courseList", courseList);

		return "viewCourses";
	}

	@RequestMapping("/deleteCourse")
	public String deleteCourse(@ModelAttribute Course course, ModelMap modelMap)
	{

		courseRepo.delete(course);
		List<Course> courseList = courseRepo.findAll();
		modelMap.addAttribute("courseList", courseList);

		return "viewCourses";
	}

}
