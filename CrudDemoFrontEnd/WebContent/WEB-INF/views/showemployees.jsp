<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.link
{
	background-color: black;
	color:white;
	padding:1px 1px;
	text-decoration: none;
}
.link:hover
{
	background-color: white;
	color:black;
}
</style>
</head>
<body>
<center>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Eamil</th>
			<th>Contact</th>
			<th>Password</th>
			<th>Update | Delete</th>
		</tr>
		<c:forEach items="${empList}" var="emp">
			<tr>
				<td>${emp.empid}</td>
				<td>${emp.name}</td>
				<td>${emp.email}</td>
				<td>${emp.contact}</td>
				<td>${emp.password}</td>
				<td><a class="link" href="getEmployeeToUpdate?id=${emp.empid}">Update</a> | <a class="link" href="deleteemployee?id=${emp.empid}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</center>
</body>
</html>