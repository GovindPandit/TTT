package com.crud;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crud.daoimplementation.EmployeeDaoImpl;
import com.crud.email.Email;
import com.crud.model.Employee;

public class EmployeeCRUD 
{

	public static void addEmployee(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		PrintWriter out=response.getWriter();
		
		Employee employee=new Employee();
		employee.setName(request.getParameter("name"));
		employee.setEmail(request.getParameter("email"));
		employee.setContact(request.getParameter("contact"));
		employee.setPassword(request.getParameter("password"));
			
		
		StringBuilder validationMessage=new StringBuilder();
		if(employee.getEmail()==null)
		{
			validationMessage.append("Email id is incorrect<br>");
		}
		if(employee.getContact()==null)
		{
			validationMessage.append("Contact id is incorrect<br>");
		}
		if(employee.getName()==null)
		{
			validationMessage.append("Name id is incorrect<br>");
		}
		if(employee.getPassword()==null)
		{
			validationMessage.append("Password id is incorrect<br>");
		}
		
		if(validationMessage.length()>1)
		{
			request.setAttribute("error", validationMessage.toString());

			RequestDispatcher requestDispatcher=null;
			requestDispatcher=request.getRequestDispatcher("/WEB-INF/views/addemployee.jsp");
				
			requestDispatcher.forward(request, response);
		}
		else
		{
			EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
			daoImpl.addEmployee(employee);
		
			Email email=new Email(employee.getEmail(), "CRUD - Registered Successfully","Welcome To CRUD");
			email.sendEmail();
		
			response.sendRedirect(request.getContextPath()+"/showemployees");
		}
	}
	public static void deleteEmployee(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		PrintWriter out=response.getWriter();
		
		Employee employee=new Employee();
		employee.setEmpid(Integer.parseInt(request.getParameter("id")));
		
		
		EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
		Employee emp2=daoImpl.readEmployee(employee);
		daoImpl.deleteEmployee(employee);
		
		Email email=new Email(emp2.getEmail(), "CRUD - Account Deletion Email","Your account deleted successfully");
		email.sendEmail();
		
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("user");
		if(username.equals("admin"))
		response.sendRedirect((request.getContextPath()+"/showemployees"));
		else
		{
		RequestDispatcher requestDispatcher=null;
		requestDispatcher=request.getRequestDispatcher("/WEB-INF/views/login.jsp");
			
		requestDispatcher.forward(request, response);
		}
	}
	public static void getEmployeeToUpdate(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		PrintWriter out=response.getWriter();
		
		Employee employee=new Employee();
		employee.setEmpid(Integer.parseInt(request.getParameter("id")));
			
			
		EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
		Employee employee2=daoImpl.readEmployee(employee);
			
		request.setAttribute("employee", employee2);
			
		RequestDispatcher requestDispatcher=null;
		requestDispatcher=request.getRequestDispatcher("/WEB-INF/views/addemployee.jsp");
			
		requestDispatcher.forward(request, response);
	}
	public static void updateEmployee(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		
		Employee employee=new Employee();
		employee.setEmpid(Integer.parseInt(request.getParameter("id")));
		employee.setName(request.getParameter("name"));
		employee.setEmail(request.getParameter("email"));
		employee.setContact(request.getParameter("contact"));
		employee.setPassword(request.getParameter("password"));
			
			
		EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
		Email email=new Email(employee.getEmail(), "CRUD - Update Account","Account Updated Successfully");
		daoImpl.updateEmployee(employee);
		email.sendEmail();
		
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("user");
		if(username.equals("admin"))
		response.sendRedirect((request.getContextPath()+"/showemployees"));
		else
		{
			out.println("<script>alert('Data updated successfully')</script>");
			getEmployeeToUpdate(request, response);
		}
	}
	public static void showEmployee(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		PrintWriter out=response.getWriter();
		
		RequestDispatcher requestDispatcher=null;
		requestDispatcher=request.getRequestDispatcher("/WEB-INF/views/showemployees.jsp");
			
		EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
		List<Employee> empList=daoImpl.readAllEmployees();
			
		request.setAttribute("empList", empList);
		requestDispatcher.forward(request, response);
	}
}
