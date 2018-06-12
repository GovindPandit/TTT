package com.crud.daoimplementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.crud.dao.EmployeeDao;
import com.crud.dbconfig.DbConfig;
import com.crud.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao
{
	PreparedStatement ps=null;
	String query="";
	
	@Override
	public boolean addEmployee(Employee e) throws Exception 
	{
		query="insert into employees (empname,email,contact,password) values (?,?,?,?)";
		ps=DbConfig.getConnection().prepareStatement(query);
		ps.setString(1, e.getName());
		ps.setString(2, e.getEmail());
		ps.setString(3, e.getContact());
		ps.setString(4, e.getPassword());
		ps.executeUpdate();
		return true;
	}

	@Override
	public boolean deleteEmployee(Employee e) throws Exception
	{
		query="delete from employees where empid=?";
		ps=DbConfig.getConnection().prepareStatement(query);
		ps.setInt(1, e.getEmpid());
		ps.executeUpdate();
		return true;
	}

	@Override
	public boolean updateEmployee(Employee e) throws Exception
	{
		query="update employees set empname=?,email=?,contact=?,password=? where empid=?";
		ps=DbConfig.getConnection().prepareStatement(query);
		ps.setString(1, e.getName());
		ps.setString(2, e.getEmail());
		ps.setString(3, e.getContact());
		ps.setInt(5, e.getEmpid());
		ps.setString(4, e.getPassword());
		ps.executeUpdate();
		return true;
	}

	@Override
	public Employee readEmployee(Employee e) throws Exception
	{
		ResultSet rs=null;
		query="Select * from employees where empid=?";
		ps=DbConfig.getConnection().prepareStatement(query);
		ps.setInt(1, e.getEmpid());
		rs=ps.executeQuery();

		if(rs!=null)
		{
			while(rs.next())
			{
				e.setEmpid(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setContact(rs.getString(4));
				e.setPassword(rs.getString(5));
			}
		}
		return e;
	}

	@Override
	public Employee readEmployeeByEmail(Employee emp) throws Exception
	{
		ResultSet resultSet=null;
		query="Select * from employees where email=?";
		ps=DbConfig.getConnection().prepareStatement(query);
		ps.setString(1, emp.getEmail());
		resultSet=ps.executeQuery();

		Employee employee=null;
		if(resultSet.next())
		{
			employee=new Employee();
			employee.setEmpid(resultSet.getInt(1));
			employee.setName(resultSet.getString(2));
			employee.setEmail(resultSet.getString(3));
			employee.setContact(resultSet.getString(4));
			employee.setPassword(resultSet.getString(5));
		}
	
		return employee;
	}

	public List<Employee> readAllEmployees() throws Exception
	{
		ResultSet rs=null;
		query="Select * from employees";
		ps=DbConfig.getConnection().prepareStatement(query);
		rs=ps.executeQuery();
		
		Employee e=new Employee();
		List<Employee> empList=new ArrayList<Employee>();
		
			while(rs.next())
			{
				Employee e1=new Employee();
				e1.setEmpid(rs.getInt(1));
				e1.setName(rs.getString(2));
				e1.setEmail(rs.getString(3));
				e1.setContact(rs.getString(4));
				e1.setPassword(rs.getString(5));
				empList.add(e1);
			}
			
		
		return empList;
	}
}
