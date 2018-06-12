<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
		<c:if test="${employee!=null and employee!=''}">
			<form action="${pageContext.request.contextPath}/updateemployee" method="post">
		</c:if>
		<c:if test="${employee==null or employee==''}">
			<form action="${pageContext.request.contextPath}/addemployee" method="post">
		</c:if>
			<table border="1">
				<c:if test="${employee!=null and employee!=''}"> 
				<tr>
					<td>Id</td>
					<td><input type="text"  value="${employee.empid}"  name="id" readonly/></td> 
				</tr>
				</c:if>
				<tr>
					<td>Name</td> 
					<td><input type="text" value="${employee.name}" name="name"/></td> 
				</tr>
				<tr>
					<td>Email</td> 
					<td><input type="text" value="${employee.email}" name="email"/></td> 
				</tr>
				<tr>
					<td>contact</td> 
					<td><input type="text" value="${employee.contact}" name="contact"/></td> 
				</tr>
				<tr>
					<td>Password</td> 
					<td><input type="password" value="${employee.password}" name="password"/></td> 
				</tr>
				<tr>
				<c:if test="${employee!=null and employee!=''}">
					<td><input type="submit" value="Update"/></td>
				</c:if>
				<c:if test="${employee==null or employee==''}">
					<td><input type="submit" value="Add"/></td>
				</c:if>  
					<td><input type="reset" value="Reset"/></td> 
				</tr>
			</table>
		</form>
		<span style="color:red">${error}</span>
	</center>
</body>
</html>