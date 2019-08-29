<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.metacube.ead.Student" %>
<%@page import="java.sql.PreparedStatement"%>
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
<a href="index.html" >home</a>
	<form action="showStudent" method="post">
		<h2 align="center"><font><strong>Student list</strong></font></h2>
			<table align="center" cellpadding="5" cellspacing="5" border="1">
			<tr>
			<td><b>roll no</b></td>
			<td><b>First name</b></td>
			<td><b>Last Name</b></td>
			<td><b>Father Name</b></td>
			<td><b>Email</b></td>
			<td><b>Class</b></td>
			<td><b>Age</b></td>
			</tr>
	<% 
	List<Student> stList = (ArrayList<Student>) request.getAttribute("StudentList");	
		for(Student st : stList){ %>	
			<tr>		
			<td><%=st.getRollNo()%></td>
			<td><%=st.getfName() %></td>
			<td><%=st.getlName() %></td>
			<td><%=st.getFatherName() %></td>
			<td><%=st.getEmail() %></td>
			<td><%=st.getStudentClass() %></td>
			<td><%=st.getAge() %></td>
			<td><a href="UpdateRecord?id=<%=st.getRollNo() %>">Update</a></td>
			</tr>
		<%} %>
	</form>
</body>
</html>