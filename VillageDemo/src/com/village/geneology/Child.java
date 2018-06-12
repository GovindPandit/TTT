package com.village.geneology;

public class Child extends Person
{
	Person father;
	Person mother;

	public  Child()
	{
		
	}
	public Person getFather() {
		return father;
	}

	public void setFather(Person father) {
		this.father = father;
	}

	public Person getMother() {
		return mother;
	}

	public void setMother(Person mother) {
		this.mother = mother;
	}

	public Child(String firstName, String lastName, String irisColor, String gender, Address add, Person father,
			Person mother) {
		super(firstName, lastName, irisColor, gender, add);
		this.father = father;
		this.mother = mother;
	}
	
	public void displayFamily(Person f,Person m,Child c)
	{	
		if(f.getIrisColor().equals(m.getIrisColor()))
		{			
			if(c.getGender().equals("male"))
				c.setIrisColor("blue");
		}
		else 
		{
			if(c.getGender().equals("male"))
				c.setIrisColor(m.getIrisColor());
			else
				c.setIrisColor(f.getIrisColor());
		}

		displayDetails();
		getFather().displayDetails();
		getMother().displayDetails();
	}
	public Child getChild(Person f,Person m)
	{
		getDetails();
		setFather(f);
		setMother(m);
		setAdd(f.getAdd());
		
		Child c=new Child(firstName, lastName, irisColor, gender, add, f, m);
		return c;
	}
}
