<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
    <center>
   	<h2>Spring CRUD Demo</h2>
   	<c:if test="${user.userid==0}">
    <form:form action="addUser" modelAttribute="user"> 
    	<table border="1">
    		<tr>
    			<td>Username</td>
    			<td><form:input path="username"/></td>
    		</tr>
    		<tr>
    			<td>Password</td>
    			<td><form:input path="password"/></td>
    		</tr>
    		<tr>
    			<td>Phone Number</td>
    			<td><form:input path="phone_number"/></td>
    		</tr>
    		<tr>
    			<td><input type="submit" value="submit"/></td>
    			<td><input type="reset" value="reset"/></td>
    		</tr>
    	</table>
    </form:form>
    </c:if>
    <c:if test="${user.userid!=0}">
    <form:form action="updateuser" modelAttribute="user" > 
    	<table border="1">
    		<tr>
    			<td>userId</td>
    			<td><form:input path="username"/></td>
    		</tr>
    		<tr>
    			<td>Username</td>
    			<td><form:input path="username"/></td>
    		</tr>
    		<tr>
    			<td>Password</td>
    			<td><form:input path="password"/></td>
    		</tr>
    		<tr>
    			<td>Phone Number</td>
    			<td><form:input path="phone_number"/></td>
    		</tr>
    		<tr>
    			<td><input type="submit" value="submit"/></td>
    			<td><input type="reset" value="reset"/></td>
    		</tr>
    	</table>
    </form:form>
    </c:if>
    
        <br><br><br>
        <table border="1">
        	<tr>
        		<td>UserId</td>
        		<td>Password</td>
        		<td>Phone Number</td>
        		<td>Username</td>
        		<td>Update | Delete</td>
        	</tr>
        	<c:forEach items="${userList}" var="user">
				<tr>
					<td>${user.userid}</td>
					<td>${user.username}</td>
					<td>${user.password}</td>
					<td>${user.phone_number}</td>
					<td><a href="edit${user.userid}">Update</a> | <a href="delete${user.userid}">Delete</a></td>
				</tr>
        	</c:forEach>
        </table>
        </center>
    </body>
</html>
