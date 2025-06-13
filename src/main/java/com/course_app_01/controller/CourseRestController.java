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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course_app_01.dto.CourseDto;
import com.course_app_01.services.CourseServices;

@RestController
@RequestMapping("/api/courses")
public class CourseRestController
{

	private static final Logger log = LoggerFactory.getLogger(CourseRestController.class);

	@Autowired
	private CourseServices courseServices;

	@PostMapping("")
	public ResponseEntity<Map<String, Object>> addCourse(@RequestBody CourseDto courseDto)
	{
		CourseDto addedCourse = courseServices.addCourse(courseDto);

		Map<String, Object> response = new HashMap<>();
		response.put("message", "Course added successfully.");
		response.put("data", addedCourse);

		return ResponseEntity.ok(response);
	}

	@GetMapping("")
	public ResponseEntity<Map<String, Object>> viewAllCourses()
	{
		List<CourseDto> courseList = courseServices.viewAllCourses();

		Map<String, Object> response = new HashMap<>();
		response.put("message", "All courses fetched successfully.");
		response.put("data", courseList);

		return ResponseEntity.ok(response);
	}

	@GetMapping("/{c_id}")
	public ResponseEntity<Map<String, Object>> getCourseById(@PathVariable("c_id") Long cId)
	{
		CourseDto courseDto = courseServices.getCourse(cId);

		Map<String, Object> response = new HashMap<String, Object>();
		response.put("message", "Course with id " + cId);
		response.put("data", courseDto);

		return ResponseEntity.ok(response);
	}

	@PatchMapping("/{c_id}")
	public ResponseEntity<Map<String, Object>> updateCourse(@PathVariable("c_id") Long cId,
			@RequestBody CourseDto courseDto)
	{
		courseDto.setC_id(cId);
		CourseDto updatedCourse = courseServices.updateCourse(courseDto);

		Map<String, Object> response = new HashMap<>();
		response.put("message", "Course updated successfully.");
		response.put("data", updatedCourse);

		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/{c_id}")
	public ResponseEntity<String> deleteCourse(@PathVariable("c_id") Long cId)
	{
		courseServices.deleteCourse(cId);
		log.info("Course with ID " + cId + " deleted successfully.");
		return ResponseEntity.ok("Course with ID " + cId + " deleted successfully.");
	}

}
