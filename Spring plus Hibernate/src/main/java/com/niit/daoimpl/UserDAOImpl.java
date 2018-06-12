package com.niit.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.niit.dao.UserDAO;
import com.niit.mobocart.UserDetails;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean deleteUserDetails(UserDetails userdetails) throws Exception 
	{
		sessionFactory.getCurrentSession().delete(userdetails);
		return true;
	}

	@Override
	public boolean addUserDetails(UserDetails userdetails) throws Exception {
		sessionFactory.getCurrentSession().save(userdetails);
		return true;
	}
	
	@Override
	public boolean updateUserDetails(UserDetails userdetails) throws Exception {
		sessionFactory.getCurrentSession().update(userdetails);
		return true;
	}

	@Override
	public UserDetails getUserDetailsById(int userid) throws Exception {
		UserDetails userDetails=(UserDetails)sessionFactory.getCurrentSession().createQuery("from UserDetails").list().get(0);
		return userDetails;
	}

	@Override
	public List<UserDetails> getuserDetails() throws Exception {
		List<UserDetails> userDetails=sessionFactory.getCurrentSession().createQuery("from UserDetails").list();
		return userDetails;
	}

}
