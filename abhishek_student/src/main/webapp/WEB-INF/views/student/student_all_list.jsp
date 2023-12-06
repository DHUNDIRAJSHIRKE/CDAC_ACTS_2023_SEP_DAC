<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Student per Course Name</title>
</head>
<body>
	<table style="background-color: lightgrey; margin: auto">
		<caption>Student List</caption>
		<tr>
			<th>Student ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Course</th>

		</tr>
		<c:forEach var="stu" items="${requestScope.all_students}">
			<tr>
				<td>${stu.studentRoll}</td>
				<td>${stu.studentFirstName}</td>
				<td>${stu.studentLastName}</td>
				<td>${stu.courseName}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>