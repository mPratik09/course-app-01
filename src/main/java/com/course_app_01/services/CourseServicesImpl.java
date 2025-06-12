package com.course_app_01.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course_app_01.dto.CourseDto;
import com.course_app_01.entity.Course;
import com.course_app_01.exception.ResourceNotFoundException;
import com.course_app_01.mapper.CourseMapper;
import com.course_app_01.repo.CourseRepo;

@Service
public class CourseServicesImpl implements CourseServices
{

	@Autowired
	private CourseRepo courseRepo;

	@Override
	public Course isExist(Long cId, String str)
	{
		Course course = courseRepo.findById(cId).orElseThrow(() -> new ResourceNotFoundException(
				"Course with ID " + cId + " not found to perform " + str + " course operation."));

		return course;
	}

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
		String str = "delete";
		isExist(cId, str);
		courseRepo.deleteById(cId);
	}

	@Override
	public CourseDto getCourse(Long cId)
	{
		String str = "fetch";
		Course course = isExist(cId, str);

		return CourseMapper.courseDtoMapper(course);
	}

	@Override
	public Course updateCourse(CourseDto courseDto)
	{
		String str = "update";
		Course course = isExist(courseDto.getC_id(), str);

		if (courseDto.getCourse_name() != null)
		{
			course.setCourse_name(courseDto.getCourse_name());
		}

		if (courseDto.getDescription() != null)
		{
			course.setDescription(courseDto.getDescription());
		}

		Course updatedCourse = courseRepo.save(course);

		return updatedCourse;
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
