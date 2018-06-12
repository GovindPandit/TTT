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
	<h2>Home Page</h2>
	<c:if test="${user!=null and user!=''}">
	<h2>Welcome ${user}</h2>
	</c:if>
	</center>
</body>
</html>