<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Add Student</title>
</head>
<body>
	<center>
		<h1>${succes }</h1>
		<h2>Search Data</h2>
		<form:form modelAttribute="SearchCommand">
			<form:errors path="${Email}"/>
				<form:label path="firstName">First Name:</form:label> 
				<form:input path="firstName" id="firstName" placeholder="Enter Student frist Name" />
				<form:errors path="firstName"/> 
				<form:label path="lastName">Last Name:</form:label> 
				<form:input path="lastName"  id="lastName" placeholder="Enter Student Last Name" />
				<form:errors path="lastName"/>
			<button type="submit">Submit</button></br></br>
			<a href="/home">Return To Home Page</a></br></br>
		</form:form>
	<c:if test="${not empty studentData}">
		
			<table border="1">
				<thead>
					<tr>
						<th>Sno.</th>
						<th>Firstname</th>
						<th>Lastname</th>
						<th>Father Name</th>
						<th>Class</th>
						<th>Email</th>
						<th>Age</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="student" items="${studentData}"
						varStatus="loopcounter">
    					<tr>
							<td>${loopcounter.count }</td>
							<td>${student.firstName }</td>
							<td>${student.lastName}</td>
							<td>${student.fatherName}</td>
							<td>${student.studentClass }</td>
							<td>${student.email}</td>
							<td>${student.studentAge}</td>
						</tr>		
 	  				</c:forEach>
				</tbody>
			</table>
		</c:if>
	</center>
</body>

</html>