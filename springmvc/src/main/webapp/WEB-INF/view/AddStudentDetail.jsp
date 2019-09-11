<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="home">home</a>
<center>
<pre>
	<mvc:form action="InsertStudent" method="Post" modelAttribute="student">
		<label>First Name</label><mvc:input path="firstName"/><mvc:errors path="firstName"></mvc:errors><br/>
		<label>Last Name</label><mvc:input path="lastName"/><mvc:errors path="lastName"></mvc:errors><br/>
		<label>Father Name<label><mvc:input path="fatherName"/><mvc:errors path="fatherName"></mvc:errors><br/>
		<label>Email <label><mvc:input path="email"/><mvc:errors path="email"></mvc:errors><br/>
		<label>Class <label><mvc:input path="studentClass" type="number"/><mvc:errors path="studentClass"></mvc:errors><br/>
		<label>Age   <label><mvc:input path="age" type="number"/><mvc:errors path="age"></mvc:errors><br/>
	
		<input type="submit" value="Add">
	</mvc:form>
	<h4>${message}</h4>
	</pre>
</center>	
</body>
</html>