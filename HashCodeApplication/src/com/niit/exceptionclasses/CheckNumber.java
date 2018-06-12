package com.niit.exceptionclasses;

public class CheckNumber
{
	public static void Check(int a,int b) throws Exception
	{
		
		if(a<b)
			throw new LesserThanException("Value is less than b");
		else if(a>b)
			throw new GreaterThanException("Value is greater than b");
	}
}
