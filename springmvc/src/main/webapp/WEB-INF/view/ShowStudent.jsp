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
	<table align="center">
		<tr>
			<th>Name</th>
			<th>Father name</th>
			<th>Email</th>
			<th>Class</th>
			<th>Age</th>
		</tr>
		<mvc:forEach items="${studentlist}" var="student">
		<tr>
			<td>${student.firstName} ${student.lastName}</td>
			<td>${student.fatherName}</td>
			<td>${student.email}</td>
			<td>${student.studentClass}</td>
			<td>${student.age}</td>
		</tr>
		</mvc:forEach>
	</table>
	<center><mvc:if test="${empty studentlist}">
			No Record Found	
			</mvc:if>
	</center>
</body>
</html>