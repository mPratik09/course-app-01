package com.course_app_01;

import javax.annotation.PostConstruct;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class FilterChecker
{

	private final ApplicationContext context;

	public FilterChecker(ApplicationContext context)
	{
		this.context = context;
	}

	@PostConstruct
	public void checkHiddenHttpMethodFilter()
	{
		boolean exists = context.containsBean("hiddenHttpMethodFilter");
		System.out.println("🔍 HiddenHttpMethodFilter registered? " + exists);
	}

}
