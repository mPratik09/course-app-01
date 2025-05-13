package com.course_app_01.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course_app_01.entity.Course;
import com.course_app_01.repo.CourseRepo;

@RestController
@RequestMapping("/api/courses")
public class CourseRestController
{

	@Autowired
	CourseRepo courseRepo;

	@RequestMapping("/viewCourses")
	public List<Course> getAllCourses()
	{
		return courseRepo.findAll();
	}

	@RequestMapping("/getCourse/{c_id}")
	public Course getCourse(@PathVariable("c_id") Long cId)
	{
		Optional<Course> findById = courseRepo.findById(cId);
		Course course = findById.get();
		return course;
	}

	@RequestMapping("/updateCourse/{c_id}")
	public Course updateCourse(@PathVariable("c_id") Long cId, @RequestBody Course course)
	{

		Optional<Course> findById = courseRepo.findById(cId);

		Course existingCourse = findById.get();

		existingCourse.setCourse_name(course.getCourse_name());
		existingCourse.setDescription(course.getDescription());

		courseRepo.save(existingCourse);

		return course;
	}

}
