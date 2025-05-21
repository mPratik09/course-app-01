package com.course_app_01.mapper;

import com.course_app_01.dto.CourseDto;
import com.course_app_01.entity.Course;

public class CourseMapper
{

	public static CourseDto courseDtoMapper(Course course)
	{
		CourseDto courseDto = new CourseDto(course.getC_id(), course.getCourse_name(), course.getDescription());
		return courseDto;
	}

	public static Course courseMapper(CourseDto courseDto)
	{
		Course course = new Course(courseDto.getC_id(), courseDto.getCourse_name(), courseDto.getDescription());
		return course;
	}

}
