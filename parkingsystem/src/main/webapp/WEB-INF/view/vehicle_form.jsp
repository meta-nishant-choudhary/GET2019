<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<pre>
			<mvc:form action="insertVehicle" method="post" modelAttribute="vehicle">
			name:  		<mvc:input path="name" type="text" pattern="[A-Za-z]*" name="name" required="required"/>
	        type:	 	<mvc:select path="type" Name="type">
							<option value="CYCLE">Cycle</option>
							<option value="MOTOR CYCLE">Motorcycle</option>
							<option value="FOUR WHEELER">Four wheeler</option>
						</mvc:select>
			number:   	<mvc:input path="number" type="number" pattern="[0-9]*" min="0001" max="9999" name="number" required="required"/>
			emplyee id: 	<mvc:input path="eid" readonly="true"/>
			identification: <mvc:input path="identification" type="textarea" name="identification" required="required"/>
			<input type="submit" value="submit">
			</mvc:form>
		</pre>
	</center>
</body>
</html>