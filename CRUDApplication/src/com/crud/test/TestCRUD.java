package com.crud.test;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.*;

import com.crud.daoimplementation.EmployeeDaoImpl;
import com.crud.model.Employee;

public class TestCRUD 
{
	Employee employee;
	@Before
	public void setUp()
	{
		employee=new Employee();
	}
	@After
	public void tearDown()
	{
		employee=null;
	}
	@Test
	public void addEmployeeTest()
	{
		try
		{
			employee.setEmpid(6);
			employee.setName("karan");
			employee.setEmail("karan@gmail.com");
			employee.setContact("7987844545");
			
			EmployeeDaoImpl edi=new EmployeeDaoImpl();
			assertEquals(true, edi.addEmployee(employee));
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	@Ignore
	@Test
	public void updateEmployeeTest()
	{
		try
		{
			employee=new Employee();
			employee.setEmpid(2);
			employee.setName("Govind");
			employee.setEmail("govind@gmail.com");
			employee.setContact("8798645456");
			

			EmployeeDaoImpl edi=new EmployeeDaoImpl();
			assertEquals(true, edi.updateEmployee(employee));
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	@Ignore
	@Test
	public void deleteEmployeeTest()
	{
		try
		{
			employee=new Employee();
			employee.setEmpid(123);
			
			EmployeeDaoImpl edi=new EmployeeDaoImpl();
			assertEquals(true, edi.deleteEmployee(employee));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	@Ignore
	@Test
	public void readOneEmployeeTest()
	{
		try
		{
			employee=new Employee();
			employee.setEmpid(1);

			EmployeeDaoImpl edi=new EmployeeDaoImpl();
			assertEquals(true, edi.readEmployee(employee));
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	@Ignore
	@Test
	public void readAllEmployeeTest()
	{
		try
		{
			EmployeeDaoImpl edi=new EmployeeDaoImpl();
			assertEquals(true, edi.readAllEmployees());
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
}

