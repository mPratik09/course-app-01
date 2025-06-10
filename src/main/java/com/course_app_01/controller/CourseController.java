package com.course_app_01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.course_app_01.dto.CourseDto;
import com.course_app_01.entity.Course;
import com.course_app_01.repo.CourseRepo;
import com.course_app_01.services.CourseServices;

@Controller
public class CourseController
{

	@Autowired
	private CourseRepo courseRepo;

	@Autowired
	private CourseServices courseServices;

	@GetMapping("/course")
	public String addSubject()
	{
		return "addCourse";
	}

	@PostMapping("/courses")
	public String addSubjectPage(@ModelAttribute CourseDto courseDto, RedirectAttributes redirectAttributes)
	{
		courseServices.addCourse(courseDto);
		redirectAttributes.addFlashAttribute("msg", "course added successflly");
		return "redirect:course";
	}

	@GetMapping("/courses")
	public String viewCourse(@ModelAttribute Course course, ModelMap modelMap)
	{
		List<Course> courseList = courseRepo.findAll();
		modelMap.addAttribute("courseList", courseList);
		return "viewCourses";
	}

	@PostMapping("/courses/{c_id}/update")
	public String updateCourse(@PathVariable("c_id") Long c_id, ModelMap modelMap)
	{
		CourseDto course = courseServices.getCourse(c_id);
		modelMap.addAttribute("course", course);
		return "editCourse";
	}

	@PostMapping("/saveUpdatedCourse")
	public String saveUpdatedCourse(@ModelAttribute CourseDto courseDto, ModelMap modelMap,
			RedirectAttributes redirectAttributes)
	{
		Course updateCourse = courseServices.updateCourse(courseDto);
		redirectAttributes.addFlashAttribute("msg", "course updated successflly with id " + courseDto.getC_id());
		return "redirect:/courses";
	}

	@DeleteMapping("/courses/{c_id}/delete")
	public String deleteCourse(@PathVariable("c_id") Long c_id, ModelMap modelMap)
	{
		courseServices.deleteCourse(c_id);
		modelMap.addAttribute("courseList", courseRepo.findAll());
		return "redirect:/courses";
	}

}
