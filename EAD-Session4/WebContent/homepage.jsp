<%@page import="com.metacube.ead.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>homepage</title>
</head>
<body>
	<a align="left" href="Logout">logout</a>
	<form action="" method="post">
		<h2 align="center"><font><strong>Employee Detail</strong></font></h2>
			<table align="center" cellpadding="5" cellspacing="5" border="1">
			<tr>
			<td><b>Id</b></td>
			<td><b>Name</b></td>
			<td><b>Gender</b></td>
			<td><b>Email</b></td>
			<td><b>Contact</b></td>
			<td><b>Organization</b></td>
			</tr>
	<% 
	Employee emp = (Employee) request.getAttribute("Employee");	
	%>	
			<tr>		
			<td><%=emp.getId()%></td>
			<td><%=emp.getName() %></td>
			<td><%=emp.getGender() %></td>
			<td><%=emp.getEmail() %></td>
			<td><%=emp.getContact() %></td>
			<td><%=emp.getOrganization() %></td>
			<td><a href="EditEmployee?id=<%=emp.getId() %>">edit</a></td>
			</tr>
	</form>
	<a href="Friends?Organization=<%=emp.getOrganization() %>&id=<%=emp.getId() %>">Friend</a>
</body>
</html>