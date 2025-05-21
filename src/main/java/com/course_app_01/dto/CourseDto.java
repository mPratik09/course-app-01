package com.course_app_01.dto;

public class CourseDto
{
	private long c_id;
	private String course_name;
	private String description;

//	Required for form binding
	public CourseDto()
	{
		super();
	}

	public CourseDto(long c_id, String course_name, String description)
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
		return "CourseDto [c_id=" + c_id + ", course_name=" + course_name + ", description=" + description + "]";
	}

}
