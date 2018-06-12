package com.niit.hashcodemain;

import com.niit.exceptionclasses.CheckNumber;

public class MainClass 
{
	public static void main(String[] args) 
	{
		Integer a=new Integer("2");
		Integer b=new Integer("2");

		try
		{
			CheckNumber.Check(a, b);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			System.out.println("Finished_Problem_3 !");
		}

	}
}
