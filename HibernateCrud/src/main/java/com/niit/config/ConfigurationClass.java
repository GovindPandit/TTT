package com.niit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.niit.mobocart.UserDetails;

@Configuration
@ComponentScan(value="com.niit.mobocart")
public class ConfigurationClass 
{
	@Bean
	public UserDetails userDetails()
	{
		return new UserDetails();
	}
}
