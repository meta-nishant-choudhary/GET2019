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
				<mvc:form action="UpdateEmployee" method="POST" modelAttribute="employee">
						<h3>Add Student Details</h3>
						 id:<mvc:input path="id" type="number" minlength="2" Name="id" min="1" value="${employee.id }" required="required" readonly="true"/>
					   Name:<mvc:input path="name" type="text" pattern="[A-Z a-z]*" minlength="2" Name="name" required="required"/>
					  Email:<mvc:input path="email" type="email" Name="Email" value="${employee.email }" required="required" readonly="true"/>
					Contact:<mvc:input path="contact" type="text" Name="contact" pattern="[0-9]*" minlength="1" maxlength="10" required="required"/>
			   Organization:<mvc:input path="org" type="text" Name="organization" value="${employee.org }" readonly="true"/>
					
							<input type="submit" value="Update"></input>
				</mvc:form>
			</pre>
		</center>
	</body>
</html>