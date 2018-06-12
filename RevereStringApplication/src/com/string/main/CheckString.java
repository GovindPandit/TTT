package com.string.main;

import com.string.checkstring.IString;

public class CheckString 
{
	public static void main(String[] args) 
	{
		IString first=new IString("Hbklm");
		IString second=new IString("Hello");
		
		if(first.equals(second))
		{
			System.out.println("same");
		}
		else
		{
			System.out.println("not same");
		}
	}
}
