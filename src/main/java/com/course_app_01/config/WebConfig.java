package com.course_app_01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@org.springframework.context.annotation.Configuration
public class WebConfig
{

	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter()
	{
		return new HiddenHttpMethodFilter();
	}

}
