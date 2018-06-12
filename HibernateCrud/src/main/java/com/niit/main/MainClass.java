package com.niit.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.UserDAO;
import com.niit.daoimpl.UserDAOImpl;
import com.niit.mobocart.UserDetails;

public class MainClass 
{
	UserDAOImpl daoImpl=new UserDAOImpl();
	public static void main(String[] args) 
	{
		MainClass m1=new MainClass();
		m1.addUserDetails();
	}
	public void addUserDetails()
	{
		try
		{
//			ApplicationContext context=new AnnotationConfigApplicationContext(ConfigurationClass.class);
//			UserDetails details=context.getBean(UserDetails.class);
//			
			UserDetails details=new UserDetails();
			details.setUsername("Govind");
			details.setPassword("Pass@123");
			details.setPhone_number("9856253268");
			
			daoImpl.addUserDetails(details);
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
			details.setUserid(34);
			details.setUsername("rahul");
			details.setPassword("pass@1234");
			details.setPhone_number("8856253268");
			
			UserDAOImpl impl=new UserDAOImpl();
			impl.updateUserDetails(details);
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
			details.setUserid(33);
			
			UserDAOImpl impl=new UserDAOImpl();
			impl.deleteUserDetails(details);
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
			UserDAOImpl impl=new UserDAOImpl();
			UserDetails userDetails=impl.getUserDetailsById(34);
			
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
			UserDAOImpl impl=new UserDAOImpl();
			List<UserDetails> userDetailsList=impl.getuserDetails();
			
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
