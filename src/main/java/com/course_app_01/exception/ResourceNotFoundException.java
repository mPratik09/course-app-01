package com.course_app_01.exception;

public class ResourceNotFoundException extends RuntimeException
{
	public ResourceNotFoundException(String message)
	{
		super(message);
	}
}
