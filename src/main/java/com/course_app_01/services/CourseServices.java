package com.course_app_01.services;

import java.util.List;

import com.course_app_01.dto.CourseDto;

public interface CourseServices
{

	CourseDto addCourse(CourseDto courseDto);

	void deleteCourse(Long cId);

	CourseDto getCourse(Long cId);

	List<CourseDto> updateCourse(CourseDto courseDto);

	List<CourseDto> viewAllCourses();

}
