package com.crud.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.EmployeeCRUD;

@WebServlet("/")
public class IndexController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			String path=request.getServletPath();
			RequestDispatcher dispatcher=null;
			
			switch(path)
			{
				case "/addemployee":
					dispatcher=request.getRequestDispatcher("/WEB-INF/views/addemployee.jsp");
					break;
				case "/login":
					dispatcher=request.getRequestDispatcher("/WEB-INF/views/login.jsp");
					break;
				case "/showemployees":
					EmployeeCRUD.showEmployee(request, response);
					break;
				case "/deleteemployee":
					EmployeeCRUD.deleteEmployee(request, response);
					break;
				case "/getEmployeeToUpdate":
					EmployeeCRUD.getEmployeeToUpdate(request, response);
					break;
				default:
					dispatcher=request.getRequestDispatcher("/WEB-INF/views/home.jsp");
					break;
			}
			dispatcher.forward(request, response);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			String path=request.getServletPath();
			RequestDispatcher dispatcher=null;
			
			switch(path)
			{
				case "/addemployee":
					EmployeeCRUD.addEmployee(request, response);
					break;
				case "/updateemployee":
					EmployeeCRUD.updateEmployee(request, response);
					break;
				default:
					dispatcher=request.getRequestDispatcher("/WEB-INF/views/home.jsp");
					break;	
			}
			dispatcher.forward(request, response);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
}

