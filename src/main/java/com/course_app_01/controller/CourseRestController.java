package com.course_app_01.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
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

	private static final Logger log = LoggerFactory.getLogger(CourseRestController.class);

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

	@PatchMapping("/updateCourse/{c_id}")
	public ResponseEntity<?> updateCourse(@PathVariable("c_id") Long cId, @RequestBody CourseDto courseDto)
	{

		if (!courseRepo.existsById(cId))
		{
			log.error("Course with ID " + cId + " not found.");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course with ID " + cId + " not found.");
		}

		courseDto.setC_id(cId);
		courseServices.updateCourse(courseDto);

		List<CourseDto> coursesList = courseServices.viewAllCourses();

		return ResponseEntity.ok(coursesList);
	}

	@RequestMapping("/deleteCourse/{c_id}")
	public List<Course> deleteCourse(@PathVariable("c_id") Long cId)
	{
		courseRepo.deleteById(cId);
		return courseRepo.findAll();
	}

}
