package com.village.geneology;

import java.util.Scanner;

public class Person
{
	Scanner sc=new Scanner(System.in);
	String firstName;
	String lastName;
	String irisColor;
	String gender;
	Address add;
	
	public Person(String firstName, String lastName, String irisColor, String gender, Address add) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.irisColor = irisColor;
		this.gender = gender;
		this.add = add;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getIrisColor() {
		return irisColor;
	}
	public void setIrisColor(String irisColor) {
		this.irisColor = irisColor;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Address getAdd() {
		return add;
	}
	public void setAdd(Address add) {
		this.add = add;
	}
	public void displayDetails()
	{
		System.out.println("First Name :- "+getFirstName());
		System.out.println("Last Name :- "+getLastName());
		System.out.println("Iris Color :- "+getIrisColor());
		System.out.println("Gender :- "+getGender());
		System.out.println("Address :- "+getAdd());
		System.out.println();
	}
	public Person()
	{
		
	}
	public void getDetails()
	{

		System.out.println("Enter first name");
		setFirstName(sc.next());
		System.out.println("Enter last name");
		setLastName(sc.next());
		System.out.println("Enter iris color");
		setIrisColor(sc.next());
		System.out.println("Enter Gender");
		setGender(sc.next());
	}
	public Person getPerson(Address a)
	{
		getDetails();
		setAdd(a);
		
		Person p=new Person(firstName, lastName, irisColor, gender, a);
		return p;
	}	
}
