package com.niit.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDAO;
import com.niit.mobocart.UserDetails;

public class MainClass 
{
	UserDAO userDAO;
	
	public MainClass()
	{
		 AnnotationConfigApplicationContext ctx = new
				  AnnotationConfigApplicationContext();
		 ctx.scan("com.niit.config");
		 ctx.refresh();
		 
		 userDAO=(UserDAO)ctx.getBean("userDAO");
	}
	
	
	public static void main(String[] args) 
	{
		MainClass m1=new MainClass();
		m1.addUserDetails();
	}

	public void addUserDetails()
	{
		try
		{
//			
			UserDetails details=new UserDetails();
			details.setUsername("Govind");
			details.setPassword("Pass@123");
			details.setPhone_number("9856253268");
			

			userDAO.addUserDetails(details);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	public void updateUserDetails() 
	{
		try
		{
			UserDetails details=new UserDetails();
			details.setUserid(2);
			details.setUsername("rahul");
			details.setPassword("pass@1234");
			details.setPhone_number("8856253268");
			

			userDAO.updateUserDetails(details);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	public void deleteUserDetails()
	{
		try
		{
			UserDetails details=new UserDetails();
			details.setUserid(1);
			details.setUsername("rahul");
			details.setPassword("pass@1234");
			details.setPhone_number("8856253268");
			
			

			userDAO.deleteUserDetails(details);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	public void getUserDetailsById() 
	{
		try
		{
			UserDetails userDetails=userDAO.getUserDetailsById(2);
			
			System.out.println("User Id: "+userDetails.getUserid());
			System.out.println("User Username: "+userDetails.getUsername());
			System.out.println("User Phone Number: "+userDetails.getPhone_number());
			System.out.println("User Password: "+userDetails.getPassword());
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	public void getUserDetails()
	{
		try
		{

			List<UserDetails> userDetailsList=userDAO.getuserDetails();
			
			for (UserDetails userDetails : userDetailsList) 
			{
				System.out.println("User Id: "+userDetails.getUserid());
				System.out.println("User Username: "+userDetails.getUsername());
				System.out.println("User Phone Number: "+userDetails.getPhone_number());
				System.out.println("User Password: "+userDetails.getPassword());
				System.out.println();
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
