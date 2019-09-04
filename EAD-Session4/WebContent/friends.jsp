<%@page import="com.metacube.ead.Employee" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="" method="post">
		<h2 align="center"><font><strong>Employee Detail</strong></font></h2>
			<table align="center" cellpadding="5" cellspacing="5" border="1">
			<tr>
			<td><b>Name</b></td>
			</tr>
	<% 
	List<Employee> emplist = (ArrayList<Employee>) request.getAttribute("employee");
		for(Employee emp : emplist) {
	%>	
			<tr>		
			<td><%=emp.getName() %></td>
			<td><a href="Profile?id=<%=emp.getId() %>">profile</a></td>
			</tr>
		<%} %>
	</form>
</body>
</html>