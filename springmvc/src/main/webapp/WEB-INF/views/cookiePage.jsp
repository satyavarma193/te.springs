<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%String message=(String)request.getAttribute("msg"); %>
    <%String employee=(String)request.getAttribute("emp"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cookie</title>
</head>
<body>
<%
	if (message != null && !message.isEmpty()) {
	%>
	<h1 style="color:red"><%=message%></h1>
	<%
	}
	%>
	<%
	if (employee != null && !employee.isEmpty()) {
	%>
	<h1 style="color:red">Employee Name: <%=employee%></h1>
	<%
	}
	%>
<h3><a href="./createcookie">create cookie</a></h3>
<h3><a href="./showcookie">show cookie</a></h3>
</body>
</html>