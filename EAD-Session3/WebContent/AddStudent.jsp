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
		if(request.getAttribute("message")!=null){
	%>
			<h3><%=request.getAttribute("message").toString() %></h3>
	<%} %>
		<pre>
		<form action="AddStudent" method="POST">
			<h3>Add Student Details</h3>
			Roll No.:		<input type="number" minlength="2" Name="roll_no" required="required"></input>
			First Name:		<input type="text" pattern="[A-Z a-z]*" minlength="2" Name="f_name" required="required"></input>
			Last Name: 		<input type="text" pattern="[A-Za-z]*" minlength="2" Name="l_name" required="required"></input>
			Father_Name: 	   	<input type="text" pattern="[A-Za-z]*" minlength="2" Name="father_name" required="required"></input>
			E-Mail: 		<input type="email" Name="Email" required="required"></input>
			Class: 			<input type="number" Name="Class" required="required"></input>
			Age: 			<input type="number" Name="Age" required="required"></input>
							<input type="submit" value="Submit"></input>
		</form>
		</pre>
		</center>
</body>
</html>