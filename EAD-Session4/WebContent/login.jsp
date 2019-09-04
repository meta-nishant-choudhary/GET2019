<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%if(request.getAttribute("message") != null) {
	%>
	<h3><%=request.getAttribute("message").toString() %></h3>
	<% } %>
	<center>
		<pre>
			<form action="Login" method="post">
				Email:    <input type="email" name="Email" required>
				password: <input type="password" name="password" required>
				<input type="submit" value="Login">
			</form>
			<a href="registration.jsp" >registration</a>
			
		</pre>
	</center>
</body>
</html>