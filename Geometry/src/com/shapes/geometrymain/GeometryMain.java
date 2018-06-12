package com.shapes.geometrymain;

import com.shapes.geometry.ThreeDGeometry;
import com.shapes.geometry.TwoDGeometry;

public class GeometryMain 
{
	public static void main(String[] args) 
	{
		TwoDGeometry square=new TwoDGeometry();
		square.computeArea(2);
		
		TwoDGeometry rectangle=new TwoDGeometry();
		rectangle.computeArea(2, 3);
		
		ThreeDGeometry cube=new ThreeDGeometry();
		cube.computeArea(3);
		
		ThreeDGeometry cuboid=new ThreeDGeometry();
		cuboid.computeArea(2,3,4);
	}
}
