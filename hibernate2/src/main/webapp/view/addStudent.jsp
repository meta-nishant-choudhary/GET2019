<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Add Student</title>
</head>
<body>
<center>
				<h1>${succes }</h1>
	
	
		<h2>Insert Data</h2>
		<form:form modelAttribute="studentCommand">
			<form:errors path="${Email}"  />
			
				<form:label path="firstName">First Name:</form:label> 
				<form:input path="firstName" id="firstName" placeholder="Enter Student frist Name" />
				<form:errors cssClass="error text-warning" path="firstName"/> <br/>
			
			
			
				<form:label path="lastName">Last Name:</form:label> 
				<form:input path="lastName"  id="lastName" placeholder="Enter Student Last Name" />
				<form:errors path="lastName"/><br/>
			
			
				
			
				<form:label path="fatherName">Father Name:</form:label> 
				<form:input path="fatherName"  id="fatherName" placeholder="Enter Father  Name" />
				<form:errors  path="fatherName"/><br/>
			
		
			
				<form:label path="email">Email:</form:label> 
				<form:input path="email"  id="Email" placeholder="Enter Email" />
				<form:errors  path="email"/><br/>
			

			
				<form:label path="studentClass">Class:</form:label>
				<form:input path="studentClass"  id="class" max="12" min="1" placeholder="Enter your class"  />
				<form:errors  path="studentClass"/> <br/>
			
			
			
				<form:label path="studentAge">Age:</form:label>
				<form:input path="studentAge" id="class" max="12" min="1" placeholder="Enter your class"  />
				<form:errors  path="studentAge"/> <br/>
			
			<button type="submit" >Submit</button> <br/>
			<a href="/home">Return To Home Page</a>
		</form:form>
	</center>
</body>

</html>