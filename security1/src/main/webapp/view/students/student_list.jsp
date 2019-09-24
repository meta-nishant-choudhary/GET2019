<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="pageTitle" scope="request" value="Students" />
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>student form</title>
</head>
	<body>
	<h3>Students</h3>
		<table>
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Father's Name</th>
					<th>Email</th>
					<th>Class</th>
					<th>Age</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${students}" var="student">
					<tr>
						<td>${student.firstName}</td>
						<td>${student.lastName}</td>
						<td>${student.fatherName}</td>
						<td>${student.email}</td>
						<td>${student.studentClass}</td>
						<td>${student.studentAge}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>