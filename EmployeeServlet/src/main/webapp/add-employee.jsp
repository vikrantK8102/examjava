<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Add New Employee</h2>
<form action="add" method="post">
    Name: <input type="text" name="name"><br><br>
    Email: <input type="email" name="email"><br><br>
    Department: <input type="text" name="department"><br><br>
    <input type="submit" value="Add Employee">
</form>
<a href="list">Back to List</a>
</body>
</html>