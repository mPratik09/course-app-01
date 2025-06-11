package com.course_app_01.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

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
		Course course = courseRepo.findById(cId)
				.orElseThrow(() -> new EntityNotFoundException("ddfdfCourse with ID " + cId + " not found"));

		return CourseMapper.courseDtoMapper(course);
	}

	@Override
	public Course updateCourse(CourseDto courseDto)
	{
		Course course = courseRepo.findById(courseDto.getC_id())
				.orElseThrow(() -> new EntityNotFoundException("Not found"));

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
