<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Log in</title>
	</head>
	<body>
	    <form method="POST" action="/login">
	        <h2>Log in</h2>
	        <span>${msg}</span>
	        <input name="username" type="text" placeholder="Username" autofocus="true"/>
	        <br>
	        <input name="password" type="password" placeholder="Password"/>
	        <span>${errorMsg}</span>
	        <br>
	        <button type="submit">Log In</button>
		</form>
	</body>
</html>