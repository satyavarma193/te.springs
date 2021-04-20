<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="header.jsp" %>
    <%String message=(String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
	 <form action="./addingdata" method="post">
		 <label>Employee_Id</label>
		 <label>:</label>
		 <input type="number" name="id">
		 <br>
		  <label>Employee_Name</label>
		 <label>:</label>
		 <input type="text" name="name">
		 <br>
		  <label>Employee_DOB</label>
		 <label>:</label>
		 <input type="date" name="birthDate">
		 <br>
		  <label>Employee_Password</label>
		 <label>:</label>
		 <input type="password" name="password">
		 <br>
		 <input type="submit" value="Add">
	 </form>
	 <%
	if (message != null && !message.isEmpty()) {
	%>
	<h1 style="color:red"><%=message%></h1>
	<%
	}
	%>
</body>
</html>