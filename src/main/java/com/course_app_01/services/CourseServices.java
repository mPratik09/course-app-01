package com.course_app_01.services;

import java.util.List;

import com.course_app_01.dto.CourseDto;
import com.course_app_01.entity.Course;

public interface CourseServices
{

	Course isExist(Long cId, String str);

	CourseDto addCourse(CourseDto courseDto);

	void deleteCourse(Long cId);

	CourseDto getCourse(Long cId);

	CourseDto updateCourse(CourseDto courseDto);

	List<CourseDto> viewAllCourses();

}
