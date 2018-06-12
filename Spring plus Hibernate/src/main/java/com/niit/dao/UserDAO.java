package com.niit.dao;

import java.util.List;

import com.niit.mobocart.UserDetails;

public interface UserDAO 
{
	public boolean addUserDetails(UserDetails userdetails) throws Exception;
	public boolean deleteUserDetails(UserDetails userdetails) throws Exception;
	public boolean updateUserDetails(UserDetails userdetails) throws Exception;
	public UserDetails getUserDetailsById(int userid) throws Exception;
	public List<UserDetails> getuserDetails() throws Exception;
}
