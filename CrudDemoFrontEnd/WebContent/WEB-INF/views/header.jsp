<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>

a
{
	background-color: black;
	color:white;
	padding:10px 12px;
	text-decoration: none;
}
a:hover
{
	background-color: white;
	color:black;
}
</style>
</head>
<body>
	<center>
		<h1>CRUD Demo</h1>
		<nav>
			<a href="${pageContext.request.contextPath}/home">Home</a>
			<c:if test="${user=='admin'}">
			<a href="${pageContext.request.contextPath}/addemployee">Add Employee</a>
			<a href="${pageContext.request.contextPath}/showemployees">Show Employee</a>
			</c:if>
			
			
			<c:if test="${user!=null and user!='' and user!='admin'}">
			<a href="${pageContext.request.contextPath}/getEmployeeToUpdate?id=${id}">Profile</a>
			<a href="${pageContext.request.contextPath}/deleteemployee?id=${id}">DeleteAccount</a>
			</c:if>
			
			<c:if test="${user!=null and user!=''}">
			<a href="${pageContext.request.contextPath}/login">Logout</a>
			</c:if>
			
			<c:if test="${user==null or user==''}">
			<a href="${pageContext.request.contextPath}/login">Login</a>
			<a href="${pageContext.request.contextPath}/addemployee">Register</a>
			</c:if>
		</nav>
		<br><br>
	</center>
</body>
</html>