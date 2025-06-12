package com.course_app_01.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course_app_01.dto.CourseDto;
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

	@GetMapping("/getCourse/{c_id}")
	public ResponseEntity<CourseDto> getCourseById(@PathVariable("c_id") Long cId)
	{
		CourseDto courseDto = courseServices.getCourse(cId);
		return ResponseEntity.ok(courseDto);
	}

	@PatchMapping("/updateCourse/{c_id}")
	public ResponseEntity<CourseDto> updateCourse(@PathVariable("c_id") Long cId, @RequestBody CourseDto courseDto)
	{
		courseDto.setC_id(cId);
		CourseDto updatedCourse = courseServices.updateCourse(courseDto);

		Map<String, Object> response = new HashMap<>();
		response.put("message", "Course updated successfully.");
		response.put("data", updatedCourse);

		return ResponseEntity.ok(updatedCourse);
	}

	@DeleteMapping("/deleteCourse/{c_id}")
	public ResponseEntity<String> deleteCourse(@PathVariable("c_id") Long cId)
	{
		courseServices.deleteCourse(cId);
		log.info("Course with ID " + cId + " deleted successfully.");
		return ResponseEntity.ok("Course with ID " + cId + " deleted successfully.");
	}

}
