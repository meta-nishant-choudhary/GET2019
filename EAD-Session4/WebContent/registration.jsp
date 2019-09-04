<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script >
	function checkValidation(form){
		password1=form.password.value;
		password2=form.cpassword.value;
		if(password1 != password2){
			alert("\nPassword did not match: Please try again..")
			return false;
		}
	}
	</script>
	<title>registration</title>
</head>
<body>
	<center>
		<pre>
			<form action="Registration" method="POST" onsubmit="return checkValidation(this)">
			<h2>Enter Personal Details</h2>
			FULL NAME   	:	<input type="text" name="empName" id="empName" minlength="2" pattern="[A-Z a-z]*" oninvalid="this.setCustomValidity('Invalid Name')" oninput="this.setCustomValidity('')"  required>
			GENDER		    :	<label><input type="radio" name="gender" value="male" checked>MALE</label><label><input type="radio" name="gender" value="female" checked>FEMALE</label>
			Email ID	    :	<input type ="email" name="email" oninput="this.setCustomValidity('')" required>
			Password	    :	<input type ="password" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" oninvalid="this.setCustomValidity('Password should contain upper & lower case and numberic and symbol')" oninput="this.setCustomValidity('')" required>
			Confirm Pass	:	<input type ="password" name="cpassword" required>
			Contact No.	    :	<input type ="number" name="contact" maxlength="10" required>
			Organization    :   <select name="type">
									<option value="metacube">Metacube</option>
									<option value="apperio">Apperio</option>
									<option value="cyntexa">Cyntexa</option>
									<option value="auriga">Auriga</option>
								</select>	
			                    <input type="submit" value="REGISTERED">
			</form>
		</pre>
		<a href="login.jsp">login</a>
	</centre>
	<center>
		<%if(request.getAttribute("message") != null) {
		%>
		<h3><%=request.getAttribute("message").toString() %></h3>
		<% } %>
	</center>
</body>
</html>