package com.company.MobileCart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.config.AppConfig;
import com.niit.dao.UserDAO;
import com.niit.mobocart.UserDetails;



@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes=AppConfig.class)

public class SpringTest 
{
	@Autowired
    UserDAO userDAO;
	
	@Before
	public void setUp() throws Exception {
			
	}

	@After
	public void tearDown() throws Exception {
		userDAO = null;
	}
	@Ignore
	@Test
	public void addUserDetails()
	{
		try
		{
//			
			UserDetails details=new UserDetails();
			details.setUsername("Govind");
			details.setPassword("Pass@123");
			details.setPhone_number("9856253268");
			
			assertEquals(true, userDAO.addUserDetails(details));
			
		}
		catch (Exception e)	{
			System.out.println(e);
		}
	}
	@Ignore
	@Test
	public void updateUserDetails() 
	{
		try
		{
			UserDetails details=new UserDetails();
			details.setUserid(2);
			details.setUsername("rahul");
			details.setPassword("pass@1234");
			details.setPhone_number("8856253268");
			

			assertEquals(true, userDAO.updateUserDetails(details));
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	@Ignore
	@Test
	public void deleteUserDetails()
	{
		try
		{
			UserDetails details=new UserDetails();
			details.setUserid(1);
			details.setUsername("rahul");
			details.setPassword("pass@1234");
			details.setPhone_number("8856253268");
			
			

			assertEquals(true, userDAO.deleteUserDetails(details));
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	@Ignore
	@Test
	public void getUserDetailsById() 
	{
		try
		{
			UserDetails userDetails=userDAO.getUserDetailsById(2);
			
			if(userDetails!=null)
			assertTrue("data inserted",true);
			if(userDetails==null)
			assertFalse("data not inserted",false);
				
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}

	@Ignore
	@Test
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
