<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>registration</title>
</head>
<body>
	<center>
		<pre>
			<mvc:form action="insertEmployee" method="POST" onsubmit="return checkValidation(this)" modelAttribute="employee">
			<h2>Enter Personal Details</h2>
			FULL NAME   	:	<mvc:input path="name" type="text" name="empName" id="empName" minlength="2" pattern="[A-Z a-z]*" oninvalid="this.setCustomValidity('Invalid Name')" oninput="this.setCustomValidity('')"  required="required"/>
			GENDER		    :	<input path="gender" type="radio" name="gender" value="male" checked="checked">MALE</label><label><input type="radio" name="gender" value="female">FEMALE</label>
			Email ID	    :	<mvc:input path="email" type ="email" name="email" required="required"/>
			Password	    :	<mvc:input path="password" type ="password" name="password" oninvalid="this.setCustomValidity('Password should contain upper & lower case and numberic and symbol')" oninput="this.setCustomValidity('')" required="required"/>
			Confirm Password:	<mvc:input path="cPassword" type ="password" name="cpassword" required="required"/>
			Contact No.	    :	<mvc:input path="contact" type ="text" pattern="[0-9]*" name="contact" required="required"/>
			Organization    :   <mvc:select path="org" name="type">
									<option value="metacube">Metacube</option>
									<option value="apperio">Apperio</option>
									<option value="cyntexa">Cyntexa</option>
									<option value="auriga">Auriga</option>
								</mvc:select>	
			                    <input type="submit" value="REGISTERED">
			</mvc:form>
		</pre>
		<a href="login">login</a>
	</centre>
	<center>
		${errormessage}
	</center>
</body>
</html>