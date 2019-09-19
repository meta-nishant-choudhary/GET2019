<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<script src="Currency.js">
</script>

<title>Insert title here</title>
</head>
<body>
	<center>
		<h2>Generate Your Pass</h2>
		<mvc:form action="login" method="post" modelAttribute="pass" onsubmit="success()">
		
		<h4>Rate Card</h4>
		<h5 id="price"></h5>
		<table align="center" border="1" id="price_list">
		<tr>
		<td>Plan</td>
		<td>Price</td>
		</tr>
		<tr>
		<td>Daily</td>
		<td></td>
		</tr>
		<tr>
		<td>Monthly</td>
		<td></td>
		</tr>
		<tr>
		<td>Yearly</td>
		<td></td>
		</tr>
		</table>
		<mvc:hidden path="type" id="v_type"/>
		<mvc:hidden path="eId"/>
		<mvc:hidden path="vId"/>
		
		Change Currency  : <select id="currencychange" onchange="currencyChangefunction()">
		<option value="">Select Currency</option>
		<option value="INR">INR</option>
		<option value="USD">USD</option>
		<option value="YEN">YEN</option>
		</select><br/>
		
		Select Your Plan : <select path="plan">
		<option value="daily">Daily</option>
		<option value="monthly">Monthly</option>
		<option value="yearly">Yearly</option>
		</select><br/>
		<input type="submit" value="Get Pass">
		</mvc:form>
		</center>
</body>
</html>