<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta charset="utf-8">
		<title>home</title>
	</head>
	<body>
		<h1>User Management System</h1>
		<br>
		<button type="submit" onclick="window.location.href = '/getUser';">Get User Details</button>
		<br> <br>
		<button type="submit" onclick="window.location.href = '/updateUser';">Update User Details</button>
		<br> <br>
		<button type="submit" onclick="window.location.href = '/getAdmin';">Get Admin Details</button>
		<br> <br>
		<button type="submit" onclick="window.location.href = '/updateAdmin';">Update Admin Details</button>
		<br> <br>
		<form id="logoutForm" method="POST" action="/logout">
			<button type="submit">Logout</button>
		</form>
	</body>
</html>