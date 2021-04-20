<%@page import="java.util.Iterator"%>
<%@page import="com.te.springmvc.beans.EmployeeBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp"%>
<%
String message = (String) request.getAttribute("errmsg");
List<EmployeeBean> dataList = (List<EmployeeBean>) request.getAttribute("data");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AllData</title>
</head>
<body>
	<form action="./showAllEmp" method="get">

		<%
		if (message != null && !message.isEmpty()) {
		%>
		<h3 style="color: red">
			<%=message%>
		</h3>
		<%
		}
		%>

		<table border="1" style="width: 50%">
			<tr style="background-color: lightgrey; color: blue; height: 30px;">
				<th>Employee Id</th>
				<th>Employee Name</th>
				<th>Employee Dob</th>
			</tr>
			<%
			for (EmployeeBean emp : dataList) {
			%>
			<tr>
				<td><%=emp.getId()%></td>
				<td><%=emp.getName()%></td>
				<td><%=emp.getBirthDate()%></td>
			</tr>
			<%
			}
			%>
		</table>
	</form>
</body>
</html>