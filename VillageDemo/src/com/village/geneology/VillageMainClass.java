package com.village.geneology;

public class VillageMainClass 
{
	public static void main(String[] args) 
	{
		System.out.println("Enter Address");
		Address a=new Address();
		Address add=a.getAddress();
		
		Person  p1=new Person();
		System.out.println("Enter Father details");
		Person f=p1.getPerson(add);
		System.out.println("Enter Mother details");
		Person m=p1.getPerson(add);
		
		
		Child c=new Child();
		System.out.println("Enter Child Details");
		Child child=c.getChild(f, m);
		
		c.displayFamily(f,m,child);
	}
}
