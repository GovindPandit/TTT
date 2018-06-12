package com.crud.model;

import com.crud.validation.ValidateEmployeeData;

public class Employee
{
	//business logic
	private int empid;
	private String name,email,contact,password;

	public Employee()
	{
		
	}
	public Employee(int empid, String name, String email, String contact,String password) {
		super();
		this.empid = empid;
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.password=password;
	}
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) 
	{
		boolean status=ValidateEmployeeData.validateId(empid);
		if(status)
			this.empid = empid;
		else
			this.empid=0;
	}
	public String getName() {
		return name;
	}
	public void setName(String name)
	{
		boolean status=ValidateEmployeeData.validateName(name);
		if(status)
			this.name = name;
		else
			this.name=null;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		
		boolean status=ValidateEmployeeData.validateEmail(email);
		if(status)
			this.email = email;
		else
			this.email=null;
	}
	public String getContact() {
		
		return contact;
	}
	public void setContact(String contact) {
		boolean status=ValidateEmployeeData.validateContact(contact);
		if(status)
			this.contact = contact;
		else
			this.contact=null;
		
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		boolean status=ValidateEmployeeData.validatePassword(password);
		if(status)
			this.password = password;
		else
			this.password=null;
	}
}
