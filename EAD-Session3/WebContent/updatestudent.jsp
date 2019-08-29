<%@page import="com.metacube.ead.Student" %>

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
	<center>
	<%
	Student student = (Student)request.getAttribute("updateStudent");
	%>
		<pre>
		<form action="UpdateStudent" method="POST">
			<h3>Add Student Details</h3>
			Roll No.:		<input type="number" minlength="2" Name="roll_no" value="<%=student.getRollNo() %>" required="required" readonly="readonly"></input>
			First Name:		<input type="text" pattern="[A-Z a-z]*" minlength="2" Name="f_name" value="<%=student.getfName() %>" required="required"></input>
			Last Name: 		<input type="text" pattern="[A-Za-z]*" minlength="2" Name="l_name" value="<%=student.getlName() %>" required="required"></input>
			Father_Name: 	   	<input type="text" pattern="[A-Za-z]*" minlength="2" Name="father_name" value="<%=student.getFatherName() %>" required="required"></input>
			E-Mail: 		<input type="email" Name="Email" value="<%=student.getEmail() %>" required="required"></input>
			Class: 			<input type="number" Name="Class" value="<%=student.getStudentClass()%>" required="required"></input>
			Age: 			<input type="number" Name="Age" value="<%=student.getAge() %>" required="required"></input>
							<input type="submit" value="Update"></input>
		</form>
		</pre>
		</center>
</body>
</html>