<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
		<h2 align="center"><font><strong>Profile</strong></font></h2>
		<table align="center" cellpadding="5" cellspacing="5" border="1">
			<tr>
				<td><b>Id</b></td>
				<td><b>Name</b></td>
				<td><b>Gender</b></td>
				<td><b>Email</b></td>
				<td><b>Contact</b></td>
				<td><b>Organization</b></td>
			</tr>
			
			<tr>		
				<td>${emp.id}</td>
				<td>${emp.name}</td>
				<td>${emp.gender }</td>
				<td>${emp.email }</td>
				<td>${emp.contact }</td>
				<td>${emp.org }</td>
			</tr>
		</table>
	</body>
</html>