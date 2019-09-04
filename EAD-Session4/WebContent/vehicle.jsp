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
			<form action="Vehicle" method="post">
			name:  		<input type="text" pattern="[A-Za-z]*" name="name" required></input>
	       type:	 	<select Name="type">
							<option value="CYCLE">Cycle</option>
							<option value="MOTOR CYCLE">Motorcycle</option>
							<option value="FOUR WHEELER">Four wheeler</option>
						</select>
			number:   	<input type="number" pattern="[A-Z0-9]*" name="number" required>
			emplyee id: 	<input type="number" value="<%=request.getAttribute("id").toString()%>" name="employeeid" readonly>
			identification: <input type="textarea" name="identification" required>
			<input type="submit" value="submit">
			</form>
			<%if(request.getAttribute("message") != null) {
			%>
			<h3><%=request.getAttribute("message").toString() %></h3>
			<% } %>
		</pre>
	</center>
</body>
</html>