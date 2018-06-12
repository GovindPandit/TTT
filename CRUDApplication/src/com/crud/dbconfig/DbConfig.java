package com.crud.dbconfig;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbConfig
{
	public static Connection getConnection()
	{
		Connection connection=null;
		try
		{
			InputStream fis=DbConfig.class.getResourceAsStream("dbinfo.properties");
			Properties prop=new Properties();
			prop.load(fis);
			
			Class.forName(prop.getProperty("driver"));
			connection=DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("username"),prop.getProperty("password"));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return connection;
	}
}
