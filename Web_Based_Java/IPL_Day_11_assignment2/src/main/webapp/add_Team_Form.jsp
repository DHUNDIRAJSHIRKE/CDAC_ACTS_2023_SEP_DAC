<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="ipl" class="beans.IPLBean" scope="application" />
<body>
	<form action="process_Team_form.jsp" method="post">
		<table style="background-color: lightgrey; margin: auto">
			<!-- <tr>
				<td>Select Team</td>
				<td><select name="myTeam">
						<option value=""></option>
				</select></td>
			</tr> -->
			<tr>
				<td>Enter Team Name</td>
				<td><input type="text" name="tn" /></td>
			</tr>
			<tr>
				<td>Enter abbreviation Name</td>
				<td><input type="text" name="abbr" /></td>
			</tr>
			<tr>
				<td>Enter Owner Name</td>
				<td><input type="text" name="on" /></td>
			</tr>
			<!-- <tr>
				<td>Select DoB</td>
				<td><input type="date" name="dob" /></td>
			</tr> -->
			<tr>
				<td>Enter max age</td>
				<td><input type="number" value="0" step="1" name="age" /></td>
			</tr>
			<tr>
				<td>Enter min Batting Average</td>
				<td><input type="number" value="0.00" step="0.01" name="avg" /></td>
			</tr>
			<tr>
				<td>Enter No Of Wickets Taken</td>
				<td><input type="number" name="wickets" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add A Player" /></td>
			</tr>
		</table>
	</form>
	<%-- <h5>Teams : ${applicationScope.ipl.fetchAllTeams()}</h5> --%>
</body>


</html>