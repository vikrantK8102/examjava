<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.app.entity.Employee, com.app.dao.EmployeeDao " %>
    <%@ page import ="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>view Employee</title>
</head>
<body>
<table>
<tr>
<th>ID</th>
<th>Name</th>
<th>city</th>
<th>Action</th>
</tr>
<%
EmployeeDao dao = new EmployeeDao();
List<Employee> list = dao.getAll();

for(Employee e:list){
%>
<tr>
<td><%=e.getId() %></td>
<td><%=e.getName() %></td>
<td><%=e.getCity() %></td>

<td>
<a href="deleteEmp.jsp?id=<%= e.getId() %>">Delete</a>
</td>
</tr>

<%} %>
</table>
</body>
</html>