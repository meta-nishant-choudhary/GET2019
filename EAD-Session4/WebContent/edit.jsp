<%@page import="com.metacube.ead.Employee" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<%
		Employee emp = (Employee)request.getAttribute("employee");
		%>
		<pre>
		<form action="UpdateEmployee" method="POST">
			<h3>Add Student Details</h3>
			id:		<input type="number" minlength="2" Name="id" min="1" value="<%=emp.getId() %>" required="required" readonly="readonly"></input>
			Name:		<input type="text" pattern="[A-Z a-z]*" minlength="2" Name="name" value="<%=emp.getName() %>" required="required"></input>
			E-Mail: 	<input type="email" Name="Email" value="<%=emp.getEmail() %>" required="required"></input>
			Contact: 	<input type="number" Name="Contact" min="1" value="<%=emp.getContact()%>" required="required"></input>
			Organization: 	<input type="text" Name="organization" value="<%=emp.getOrganization() %>" required="required"></input>
			
							<input type="submit" value="Update"></input>
		</form>
		</pre>
		</center>
</body>
</html>