<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Employee Manager</title>
</head>
<body>
	<h5>
		<spring:url var="url" value="/employee/add" />
		<a href="${url}">Add Employee Form</a>
	</h5>
</body>
</html>