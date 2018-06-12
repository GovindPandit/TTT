package com.crud.dao;

import java.util.List;

import com.crud.model.Employee;

public interface EmployeeDao 
{
	//persistence logic
	public boolean addEmployee(Employee e) throws Exception;
	public boolean deleteEmployee(Employee e) throws Exception;
	public boolean updateEmployee(Employee e) throws Exception;
	public Employee readEmployee(Employee e) throws Exception;
	public Employee readEmployeeByEmail(Employee e) throws Exception;
	public List<Employee> readAllEmployees() throws Exception;
}
