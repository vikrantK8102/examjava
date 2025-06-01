<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.app.entity.Employee , com.app.dao.EmployeeDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>deleteEmp</title>
</head>
<body>
<a href="viewEmp.jsp">View Employee</a>
<hr>
<%
String idstr = request.getParameter("id");
if(idstr!=null){
	int id = Integer.parseInt(request.getParameter("idstr"));
	EmployeeDao dao = new EmployeeDao();
	dao.deteteEmp(id);
	response.sendRedirect("viewEmp.jsp");
	
}
else{
	
%>

<h3 style="color:red">Invalid emp Id</h3>

	<% }%>


</body>
</html>