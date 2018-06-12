package com.niit.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.OptimisticLockException;

import org.hibernate.dialect.lock.OptimisticEntityLockException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.niit.daoimpl.UserDAOImpl;
import com.niit.mobocart.UserDetails;

public class TestClass
{
	UserDetails details=null;
	@Before
	public void setUp()
	{
		details=new UserDetails();
	}
	@After
	public void tearDown()
	{
		details=null;
	}
	
	@Test
	public void addUserDetails() throws Exception
	{
		details.setUsername("Govind");
		details.setPassword("pass@123");
		details.setPhone_number("9856253268");
		
		UserDAOImpl impl=new UserDAOImpl();
			
		assertEquals(true, impl.addUserDetails(details));
	}
	
	@Test
	public void updateUserDetails() throws Exception 
	{
		details.setUserid(34);
		details.setUsername("rahul");
		details.setPassword("pass@1234");
		details.setPhone_number("8856253268");
			
		UserDAOImpl impl=new UserDAOImpl();
			
		assertEquals(true, impl.updateUserDetails(details));
	}
	
	@Test(expected=OptimisticLockException.class)
	public void deleteUserDetails() throws Exception
	{
		details.setUserid(33);
		UserDAOImpl impl=new UserDAOImpl();
		assertEquals(true, impl.deleteUserDetails(details));
	}
	
	@Test
	public void getUserDetailsById() throws Exception 
	{
		UserDAOImpl impl=new UserDAOImpl();
		details=impl.getUserDetailsById(37);
		
		if(details!=null)
			assertTrue("data is not empty",true);
		if(details==null)
			assertFalse("Data is empty", false);
	}
	
	@Test
	public void getUserDetails() throws Exception
	{
		UserDAOImpl impl=new UserDAOImpl();
		List<UserDetails> userDetailsList=impl.getuserDetails();
	
		if(userDetailsList!=null)
			assertTrue("data is not empty",true);
		if(userDetailsList==null)
			assertFalse("data is not empty",false);
	}

}
