<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		<script src="Currency.js">
		</script>
		<script>
		function success() {
			alert("Registered Successfully");	
		}
		</script>
	</head>
	<body>
	<center>
		<h2>Generate Your Pass</h2>
		<form action="Pass" method="post" onsubmit="success()">
		
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
		<input type="hidden" id="v_type" name="v_type" value="<%=request.getAttribute("type").toString() %>">
		<input type="hidden" name="emp_id" value="<%=request.getAttribute("eid").toString() %>">
		<input type="hidden" name="vehicle_id" value="<%=request.getAttribute("id").toString() %>">
		
		Change Currency  : <select name="change" id="currencychange" onchange="currencyChangefunction()" required>
		<option value="">Select Currency</option>
		<option value="INR">INR</option>
		<option value="USD">USD</option>
		<option value="YEN">YEN</option>
		</select><br>
		Select Your Plan : <select name="plan">
		<option value="daily">Daily</option>
		<option value="monthly">Monthly</option>
		<option value="yearly">Yearly</option>
		</select>
		<input type="submit" value="Get Pass">
		</form>
		</center>
		
	</body>
</html>