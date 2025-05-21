package com.course_app_01.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course_app_01.dto.CourseDto;
import com.course_app_01.entity.Course;
import com.course_app_01.repo.CourseRepo;
import com.course_app_01.services.CourseServices;

@RestController
@RequestMapping("/api/courses")
public class CourseRestController
{

	@Autowired
	private CourseRepo courseRepo;

	@Autowired
	private CourseServices courseServices;

	@RequestMapping("/addCourse")
	public CourseDto addCourse(@RequestBody CourseDto courseDto)
	{
		return courseServices.addCourse(courseDto);
	}

	@RequestMapping("/viewAllCourses")
	public List<CourseDto> viewAllCourses()
	{
		return courseServices.viewAllCourses();
	}

	@RequestMapping("/getCourse/{c_id}")
	public Course getCourse(@PathVariable("c_id") Long cId)
	{
		Optional<Course> findById = courseRepo.findById(cId);
		Course course = findById.get();
		return course;
	}

	@RequestMapping("/updateCourse/{c_id}")
	public List<CourseDto> updateCourse(@PathVariable("c_id") Long cId, @RequestBody CourseDto courseDto)
	{
		courseDto.setC_id(cId);
		return courseServices.updateCourse(courseDto);

	}

	@RequestMapping("/deleteCourse/{c_id}")
	public List<Course> deleteCourse(@PathVariable("c_id") Long cId)
	{
		courseRepo.deleteById(cId);
		return courseRepo.findAll();
	}

}
