<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	isErrorPage="true"%>

<%String message=(String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error-page</title>
</head>
<body>
	<%
	if (message != null && !message.isEmpty()) {
	%>
	<h1 style="color: red;text-align: center;margin: auto;"><%=message%></h1>
	<%
	}
	%>
</body>
</html>