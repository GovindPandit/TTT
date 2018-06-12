package com.niit.daoimpl;

import java.util.List;
import org.hibernate.Session;
import com.niit.dao.UserDAO;
import com.niit.dbconfig.DBConfig;
import com.niit.mobocart.UserDetails;

public class UserDAOImpl implements UserDAO
{
	Session session=null;
	
	
	public boolean deleteUserDetails(UserDetails userdetails) throws Exception 
	{
		session=DBConfig.getSession();
		session.getTransaction().begin();
		session.delete(userdetails);
		session.getTransaction().commit();
		return true;
	}


	public boolean updateUserDetails(UserDetails userdetails) throws Exception 
	{
		session=DBConfig.getSession();
		session.getTransaction().begin();
		session.update(userdetails);
		session.getTransaction().commit();
		return true;
	}


	public UserDetails getUserDetailsById(int userid) throws Exception 
	{
		session=DBConfig.getSession();
		UserDetails userDetails = (UserDetails) session.createQuery("from UserDetails where userid = "+userid).getResultList().get(0);
		
		return userDetails;
	}

	
	public List<UserDetails> getuserDetails() throws Exception 
	{
		session=DBConfig.getSession();
		List<UserDetails> userDetails = session.createQuery("from UserDetails").getResultList();
		return userDetails;
	}

	public boolean addUserDetails(UserDetails userdetails) throws Exception 
	{
		session=DBConfig.getSession();
		session.getTransaction().begin();
		session.save(userdetails);
		session.getTransaction().commit();
		return true;
	}
}
