package com.crud.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crud.daoimplementation.EmployeeDaoImpl;
import com.crud.model.Employee;

@WebServlet("/logincontroller")
public class LoginController extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		try
		{
			Employee emp=new Employee();
			emp.setEmail(request.getParameter("email"));
			emp.setPassword(request.getParameter("password"));
		
			RequestDispatcher dispatcher=null;
			
			if(emp.getPassword().equals("pass@123") && emp.getEmail().equals("admin123@gmail.com"))
			{
				HttpSession session=request.getSession();
				session.setAttribute("user", "admin");
				dispatcher=request.getRequestDispatcher("/WEB-INF/views/home.jsp");
				dispatcher.forward(request, response);
			}
			
			EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
			Employee empToCheck=daoImpl.readEmployeeByEmail(emp);
			if(empToCheck!=null)
			{	
				if(empToCheck.getPassword().equals(emp.getPassword()))
				{	
					HttpSession session=request.getSession();
					session.setAttribute("user", empToCheck.getName());
					session.setAttribute("id", empToCheck.getEmpid());
					dispatcher=request.getRequestDispatcher("/WEB-INF/views/home.jsp");
				}
				else
				{
					dispatcher=request.getRequestDispatcher("/WEB-INF/views/error.jsp");
				}
			}
			else
			{
					dispatcher=request.getRequestDispatcher("/WEB-INF/views/error.jsp");
			}
			dispatcher.forward(request, response);
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}
