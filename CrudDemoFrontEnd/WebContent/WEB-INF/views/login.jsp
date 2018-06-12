<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="/WEB-INF/css/link.css" rel="stylesheet"/>
</head>
<body>
	<center>
	<%
		HttpSession hs=request.getSession();
		hs.removeValue("user");
		hs.removeAttribute("user");
	%>
	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	<h2>Login Form</h2>
	<form action="logincontroller" method="post">
		<table border="1">
			<tr>
				<td>Email</td>
				<td><input type="text" name="email"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td><input type="Submit" value="Login"/></td>
				<td><input type="Submit" value="Reset"/></td>
			</tr>
		</table>
	</form>
	</center>
</body>
</html>