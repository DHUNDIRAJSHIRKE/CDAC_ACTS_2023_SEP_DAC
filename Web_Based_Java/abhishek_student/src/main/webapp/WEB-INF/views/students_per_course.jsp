<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Specific List per Course</title>
</head>
<%-- <jsp:useBean id="team" class="beans.TeamBean" scope="session" />
<jsp:useBean id="player" class="beans.PlayerBean" scope="session" /> --%>
<body>
	<form action="student/show_specific" method="post">
		<table style="background-color: lightgrey; margin: auto">
		<!-- //1. emp no2. first name3. last name4. city 5. company name -->		
			<tr>
				<td>Enter course</td>
				<td><input type="text" name="course" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Show Students" /></td>
			</tr>
		</table>
	</form>
</body>


</html>