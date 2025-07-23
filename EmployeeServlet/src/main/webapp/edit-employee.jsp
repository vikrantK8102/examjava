<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.app.dao.EmployeeDao, com.app.model.Employee" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    Employee emp = new EmployeeDao().getEmployeeById(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Edit Employee</h2>
<form action="update" method="post">
    <input type="hidden" name="id" value="<%= emp.getId() %>">
    Name: <input type="text" name="name" value="<%= emp.getName() %>"><br><br>
    Email: <input type="email" name="email" value="<%= emp.getEmail() %>"><br><br>
    Department: <input type="text" name="department" value="<%= emp.getDepartment() %>"><br><br>
    <input type="submit" value="Update">
</form>
<a href="list">Back to List</a>
</body>
</html>