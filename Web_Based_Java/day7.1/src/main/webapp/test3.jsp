<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%!String mesg = "some mesg";//private data member%>
<meta charset="ISO-8859-1">
<title>test3</title>
</head>
<body>
	<h3>From including page....</h3>
	<%
	String anotherMesg = "another mesg...";//method local var : _jspService
	//create page scoped attr
	pageContext.setAttribute("nm", 12345);
	%>
	<%@ include file="test4.jsp"%>
</body>
</html>