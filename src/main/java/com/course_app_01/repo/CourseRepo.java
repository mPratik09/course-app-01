package com.course_app_01.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course_app_01.entity.Course;

public interface CourseRepo extends JpaRepository<Course, Long>
{

}
