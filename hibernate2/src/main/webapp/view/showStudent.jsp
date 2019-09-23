<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	 <meta charset="utf-8">
	 <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Home page</title>
</head>
<body>
	
      
      <p ><a href="home">Home Page</a></p>
   <center>
    <table>
      <thead>
        <tr>
          <th>#</th>
          <th>Firstname</th>
          <th>Lastname</th>
          <th>Father Name</th>
          <th>Class</th>
          <th>Email</th>
          <th>Age</th>
        </tr>
      </thead>
      <tbody>
      <c:if test="${not empty studentDetails}">
    	 <c:forEach var="student" items="${studentDetails}" varStatus="loopcounter">
    	
         <tr>
          <td> ${loopcounter.count }</td>
          <td> ${student.firstName }</td>
          <td> ${student.lastName}</td>
          <td> ${student.fatherName} </td>
          <td> ${student.studentClass }</td>
          <td> ${student.email}</td>
          <td> ${student.studentAge}</td>
        </tr>		
 	  	</c:forEach>
	  </c:if>
      </tbody>
    </table>
</center>
</body>

</html>