<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="header.jsp"%>
    <%int id=(int)request.getAttribute("id"); %>
    <%String message=(String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update</title>
</head>
<body>
<%
	if (message != null && !message.isEmpty()) {
	%>
	<h1 style="color:red"><%=message%></h1>
	<%
	}
	%>
	 <form action="./updateempdata" method="post">
		 <label>Employee_Id</label>
		 <label>: <%=id %></label>
		 <input type="text" value="<%=id %>" hidden="true" name="id">
		 <br>
		  <label>Employee_Name</label>
		 <label>:</label>
		 <input type="text" name="name">
		 <br>
		  <label>Employee_DOB</label>
		 <label>:</label>
		 <input type="date" name="dob">
		 <br>
		  <label>Employee_Password</label>
		 <label>:</label>
		 <input type="password" name="pwd">
		 <br>
		 <input type="submit" value="Update">
	 </form>
</body>
</html>