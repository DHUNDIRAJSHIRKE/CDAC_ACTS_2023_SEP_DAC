<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%--invoke All matching setters --%>
<jsp:setProperty property="*" name="user" />
<body>
<%-- invoke Business Logic method for Voter registration --%>
<h5> Status : ${sessionScope.user.registerVoter()}</h5>
</body>
</html>