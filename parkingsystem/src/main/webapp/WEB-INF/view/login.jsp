<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<pre>
			<form action="logincheck" method="post" >
				Email:    <input type="email" name="Email" required="required"/>
				password: <input type="password" name="password" required="required"/>
				<input type="submit" value="Login">
			</form>
			<a href="index" >registration</a>
			${message}
		</pre>
	</center>
</body>
</html>