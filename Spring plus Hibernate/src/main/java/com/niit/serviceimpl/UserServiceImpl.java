package com.niit.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.UserDAO;
import com.niit.mobocart.UserDetails;
import com.niit.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	UserDAO userDAO;
	
	@Override
	public boolean addUserDetails(UserDetails userdetails) throws Exception 
	{
		userDAO.addUserDetails(userdetails);
		return true;
	}

	@Override
	public boolean deleteUserDetails(UserDetails userdetails) throws Exception 
	{
		userDAO.deleteUserDetails(userdetails);
		return true;
	}

	@Override
	public boolean updateUserDetails(UserDetails userdetails) throws Exception 
	{
		userDAO.updateUserDetails(userdetails);
		return true;
	}

	@Override
	public UserDetails getUserDetailsById(int userid) throws Exception 
	{
		UserDetails userDetails=userDAO.getUserDetailsById(userid);
		return userDetails;
	}

	@Override
	public List<UserDetails> getuserDetails() throws Exception 
	{
		List<UserDetails> userList=userDAO.getuserDetails();
		return userList;
	}

}
