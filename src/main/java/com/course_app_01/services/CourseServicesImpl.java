package com.course_app_01.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course_app_01.dto.CourseDto;
import com.course_app_01.entity.Course;
import com.course_app_01.mapper.CourseMapper;
import com.course_app_01.repo.CourseRepo;

@Service
public class CourseServicesImpl implements CourseServices
{

	@Autowired
	private CourseRepo courseRepo;

	@Override
	public CourseDto addCourse(CourseDto courseDto)
	{
		Course course = CourseMapper.courseMapper(courseDto);
		Course savedCourse = courseRepo.save(course);
		return CourseMapper.courseDtoMapper(savedCourse);
	}

	@Override
	public void deleteCourse(Long cId)
	{
		courseRepo.deleteById(cId);
	}

	@Override
	public CourseDto getCourse(Long cId)
	{
		Optional<Course> findById = courseRepo.findById(cId);
		Course course = findById.get();
		return CourseMapper.courseDtoMapper(course);
	}

	@Override
	public List<CourseDto> updateCourse(CourseDto courseDto)
	{
		Course course = CourseMapper.courseMapper(courseDto);
		courseRepo.save(course);
		List<CourseDto> courseList = new ArrayList<>();

		for (Course course2 : courseRepo.findAll())
		{
			CourseDto courseDtoMapper = CourseMapper.courseDtoMapper(course2);
			courseList.add(courseDtoMapper);
		}
		return courseList;
	}

	@Override
	public List<CourseDto> viewAllCourses()
	{
		List<CourseDto> courseList = new ArrayList<>();

		for (Course course : courseRepo.findAll())
		{
			CourseDto courseDtoMapper = CourseMapper.courseDtoMapper(course);
			courseList.add(courseDtoMapper);
		}

		return courseList;
	}

}
