<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="pageTitle" scope="request" value="Add Student" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>student form</title>
	</head>
	<body>
		<h3>Add Student Details</h3>
			<form:form modelAttribute="studentForm">
				<form:errors/>

					<form:label path="firstName">First Name</form:label>
					<form:input path="firstName" type="text" id="student_first_name" placeholder="First Name" />
					<form:errors path="firstName" />
					<form:label path="lastName">Last Name</form:label>
					<form:input path="lastName" type="text" id="student_last_name"	placeholder="Last Name" />
					<form:errors path="lastName" />
					<form:label path="fatherName">Father's Name</form:label>
					<form:input path="fatherName" type="text" id="student_father_name" placeholder="Father's Name" />
					<form:errors path="fatherName" />
					<form:label path="email">Email address</form:label>
					<form:input path="email" type="email" id="student_email" placeholder="Email" />
					<form:errors path="email" />
					<form:label path="studentClass">Class</form:label>
					<form:input path="studentClass" type="text" id="student_class" placeholder="Class" />
					<form:errors path="studentClass" />
					<form:label path="studentAge">Age</form:label>
					<form:input path="studentAge" type="text" id="student_age" placeholder="Age" />
					<form:errors path="studentAge"/>
				<button type="submit">Submit</button>
			</form:form>
	</body>
</html>