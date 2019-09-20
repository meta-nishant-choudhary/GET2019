<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="mvc" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a align="left" href="Logout">logout</a>
		<h2 align="center"><font><strong>Friends</strong></font></h2>
			<table align="center" cellpadding="5" cellspacing="5" border="1">
			<tr>
			<td><b>Name</b></td>
			
			</tr>
			<mvc:forEach items="${friendList}" var="friend">
			<tr>			
			<td>${friend.name}</td><td><a href="profile?id=${friend.id}">profile</a></td>
			</tr>
			
			</mvc:forEach>
</body>
</html>