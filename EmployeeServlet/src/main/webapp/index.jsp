<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, com.app.model.Employee" %>
<html>
<head><title>Employee List</title></head>
<body>
<h2>Employee List</h2>
<a href="add-employee.jsp">Add New Employee</a>
<table border="1" cellpadding="10">
    <tr>
        <th>ID</th><th>Name</th><th>Email</th><th>Department</th><th>Actions</th>
    </tr>
    <%
        List<Employee> list = (List<Employee>) request.getAttribute("empList");
        if (list != null) {
            for (Employee emp : list) {
    %>
    <tr>
        <td><%= emp.getId() %></td>
        <td><%= emp.getName() %></td>
        <td><%= emp.getEmail() %></td>
        <td><%= emp.getDepartment() %></td>
        <td>
            <a href="edit-employee.jsp?id=<%= emp.getId() %>">Edit</a> |
            <a href="delete?id=<%= emp.getId() %>">Delete</a>
        </td>
    </tr>
    <%
            }
        } else {
    %>
    <tr>
        <td colspan="5">No employee data available.</td>
    </tr>
    <% } %>
</table>
</body>
</html>
