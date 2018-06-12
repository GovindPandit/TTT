package com.niit.container;

public class Container 
{
	int length,width,hieght,volume;
	
	public Container(int length, int width, int hieght) {
		super();
		this.length = length;
		this.width = width;
		this.hieght = hieght;
	}


	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHieght() {
		return hieght;
	}


	public int getVolume() {
		return volume;
	}


	public void setVolume(int volume) {
		this.volume = volume;
	}


	public void setHieght(int hieght) {
		this.hieght = hieght;
	}

	public int volumeCalculator(Container c)
	{
		this.volume=length*width*hieght;
		return this.volume;
	}
}
