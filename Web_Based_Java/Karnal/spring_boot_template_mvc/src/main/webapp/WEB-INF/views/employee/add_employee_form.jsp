<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee Form</title>
</head>
<body>
	<h5 style="color: red;">${sessionScope.mesg }</h5>
	<spring:url var="url" value="/employee/show" />
	<form:form action="${url}" method="post" modelAttribute="employee">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Enter First Name</td>
				<td><form:input path="fName" /></td>

			</tr>
			<tr>
				<td>Enter Last Name</td>
				<td><form:input path="lName" /></td>
			</tr>
			<tr>
				<td>Enter City</td>
				<td><form:input path="city" /></td>
			</tr>
			<tr>
				<td>Enter Company Name</td>
				<td><form:input path="companyName" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add Employee" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>