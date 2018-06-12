package com.niit.dbconfig;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.niit.mobocart.UserDetails;

public class DBConfig 
{
	private static SessionFactory factory=null;
	
	public static SessionFactory getFactory() {
		return factory;
	}

	public static void setFactory(SessionFactory factory) {
		DBConfig.factory = factory;
	}

	static
	{
		try
		{
			System.out.println("not successfull");
			loadSessionFactory();
			System.out.println("successfull");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static void loadSessionFactory()
	{
		Configuration configuration=new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(UserDetails.class);
		ServiceRegistry registry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		setFactory(configuration.buildSessionFactory(registry));
	}
	
	public static Session getSession() throws Exception
	{
		Session session=getFactory().openSession();
		return session;
	}
}
