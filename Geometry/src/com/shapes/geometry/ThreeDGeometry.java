package com.shapes.geometry;

public class ThreeDGeometry extends TwoDGeometry
{

	@Override
	public void computeArea(int a)
	{
		System.out.println("Cube: "+(a*a*a));
	}
	
	public void computeArea(int a,int b, int c)
	{
		System.out.println("Cuboid : "+(a*b*c));
	}
	
}
