package com.niit.main;

import com.niit.ContainerException.CheckContainerVolume;
import com.niit.container.*;

public class ContainerMain
{
	public static void main(String[] args) 
	{
		Container c1=new Container(2, 3, 4);
		Container c2=new Container(1, 1, 1);
		
		try
		{
			System.out.println("Difference: "+c1.volumeCalculator(c1)+" - "+c2.volumeCalculator(c2)+" = "+CheckContainerVolume.check(c1, c2));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
