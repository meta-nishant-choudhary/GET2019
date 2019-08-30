<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.metacube.ead.Student" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Student</title>
</head>
<body>
	<a href="index.html" >home</a>
	<center>
	<pre>
	<form action="SearchStudent" method="Post">
		<select Name="type">
			<option value="first_name">First Name</option>
			<option value="last_name">Last Name</option>
		</select>
		<input type="checkbox" name="checkbox" value="class">Class Wise</input>
		<label>Enter value to search: </label>
		<input type="text" name="name" pattern="[A-Za-z]*" required="required">
		<input type="submit"></input>
	</form>
	</pre>
	</center>
		
		<%if(request.getAttribute("Student") != null) {
			
		%>
		
		<h2 align="center"><font><strong>Student list</strong></font></h2>
			<table align="center" cellpadding="5" cellspacing="5" border="1">
			<tr>
			<td><b>First name</b></td>
			<td><b>Last Name</b></td>
			<td><b>Father Name</b></td>
			<td><b>Email</b></td>
			<td><b>Class</b></td>
			<td><b>Age</b></td>
			</tr>
	<% 
		List<Student> stList = (ArrayList<Student>) request.getAttribute("Student");	
		for(Student st : stList){ %>	
			<tr>		
			<td><%=st.getfName() %></td>
			<td><%=st.getlName() %></td>
			<td><%=st.getFatherName() %></td>
			<td><%=st.getEmail() %></td>
			<td><%=st.getStudentClass() %></td>
			<td><%=st.getAge() %></td>
			</tr>
		<%} }%>
		<%if(request.getAttribute("message") != null) {
		%><center>
		<%=request.getAttribute("message").toString() %>
		<%} %>
		</center>
	</center>
</body>
</html>
