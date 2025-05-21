package com.course_app_01.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.course_app_01.dto.CourseDto;
import com.course_app_01.entity.Course;
import com.course_app_01.repo.CourseRepo;
import com.course_app_01.services.CourseServices;

@Controller
public class CourseController
{

	@Autowired
	private CourseRepo courseRepo;

	@Autowired
	private CourseServices courseServices;

	@RequestMapping("/addCourse")
	public String addSubject()
	{
		return "addCourse";
	}

	@RequestMapping("/courseAdded")
	public String addSubjectPage(@ModelAttribute CourseDto courseDto)
	{
		courseServices.addCourse(courseDto);
//		code to be added for message passing (user added successfully)
		return "addCourse";
	}

	@RequestMapping("/viewAllCourses")
	public String viewCourse(@ModelAttribute Course course, ModelMap modelMap)
	{
		List<Course> courseList = courseRepo.findAll();
		modelMap.addAttribute("courseList", courseList);
		return "viewCourses";
	}

	@RequestMapping("/updateCourse")
	public String upadteCourse(@PathParam("c_id") Long c_id, ModelMap modelMap)
	{
		CourseDto course = courseServices.getCourse(c_id);
		modelMap.addAttribute("course", course);
		return "editCourse";
	}

	@RequestMapping("/saveUpdatedCourse")
	public String saveUpdatedCourse(@ModelAttribute CourseDto courseDto, ModelMap modelMap)
	{
		List<CourseDto> courseList = courseServices.updateCourse(courseDto);
		modelMap.addAttribute("courseList", courseList);
		return "viewCourses";
	}

	@RequestMapping("/deleteCourse")
	public String deleteCourse(@PathParam("c_id") Long c_id, ModelMap modelMap)
	{

		courseServices.deleteCourse(c_id);
		List<Course> courseList = courseRepo.findAll();
		modelMap.addAttribute("courseList", courseList);

		return "viewCourses";
	}

}
