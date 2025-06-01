<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.app.bean.*,com.app.dao.*" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Books</title>
</head>
<body>
<h1>Books List</h1>
<hr>

<%
    List<Book> list = BookDao.getAllBooks();
    request.setAttribute("list", list);
%>

<table border="1" width="100%">
<tr>
    <th>ID</th>
    <th>Title</th>
    <th>Author</th>
    <th>Publisher</th>
    <th>Quantity</th>
    <th>Issued</th>
    <th>Edit</th>
    <th>Delete</th>
</tr>

<c:forEach var="b" items="${list}">
<tr>
    <td>${b.getId()}</td>
    <td>${b.getTitle()}</td>
    <td>${b.getAuthor()}</td>
    <td>${b.getPublisher()}</td>
    <td>${b.getQuantity()}</td>
    <td>${b.getIssued()}</td>
    <td><a href="editBook.jsp?id=${b.getId()}">Edit</a></td>
    <td><a href="deleteBook.jsp?id=${b.getId()}">Delete</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>
