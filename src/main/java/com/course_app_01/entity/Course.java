package com.course_app_01.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long c_id;

//	@NotNull(message = "Course name nust not be null")
//	@NotNull
	private String course_name;
	private String description;

	public Course()
	{
		super();
	}

	public Course(long c_id, String course_name, String description)
	{
		super();
		this.c_id = c_id;
		this.course_name = course_name;
		this.description = description;
	}

	public long getC_id()
	{
		return c_id;
	}

	public void setC_id(long c_id)
	{
		this.c_id = c_id;
	}

	public String getCourse_name()
	{
		return course_name;
	}

	public void setCourse_name(String course_name)
	{
		this.course_name = course_name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	@Override
	public String toString()
	{
		return "Course [c_id=" + c_id + ", course_name=" + course_name + ", description=" + description + "]";
	}

}
