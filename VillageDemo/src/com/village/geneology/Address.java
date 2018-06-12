package com.village.geneology;

import java.util.Scanner;

public class Address 
{
	String city,state,street;
	int pincode;
	Scanner sc=new Scanner(System.in);
	
	public Address(String city, String state, String street, int pincode) {
		super();
		this.city = city;
		this.state = state;
		this.street = street;
		this.pincode = pincode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "City: "+city+", State: "+state+", Street: "+street+", Pincode: "+pincode;
	}
	public Address()
	{
		
	}
	public Address getAddress()
	{
		System.out.println("Enter city");
		setCity(sc.next());
		System.out.println("Enter state");
		setState(sc.next());
		System.out.println("Enter Pincode");
		setPincode(sc.nextInt());
		System.out.println("Enter street");
		setStreet(sc.next());
		
		Address a=new Address(city, state, street, pincode);
		return a;
	}
	
}
