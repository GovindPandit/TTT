package com.niit.ContainerException;

import com.niit.container.Container;

public class CheckContainerVolume 
{
	public static int check(Container c1,Container c2) throws ContainerException 
	{
		int difference;
		int volume1=c1.volumeCalculator(c1);
		int volume2=c2.volumeCalculator(c2);;
		
		if(volume1<=volume2 || c1.getHieght()<=c2.getHieght() 
		   || c1.getLength()<=c2.getLength() || c1.getWidth()<=c2.getWidth())
		{
			throw new ContainerException("Error!!! Second container should be lesser values than first container");
		}
		else
		{
			difference = volume1-volume2;
		}
		return difference;
	}
}
