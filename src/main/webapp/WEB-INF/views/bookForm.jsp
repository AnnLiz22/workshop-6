<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<html>
<head>
    <title>Book form</title>
    <style>
        table {
            border-collapse: collapse;
        }

        th, td {
            padding: 0.2rem;
            border: 1px solid black;
            text-align: center;
        }
    </style>
</head>
<body>
<nav>
<a href="${pageContext.request.contextPath}/admin/books/form">Add new book</a>
<a href="${pageContext.request.contextPath}/admin/books/all">Book list</a>
</nav>
<h3>Book form</h3>
<form:form action="/admin/books/form" method="post"  modelAttribute="book">
    <form:hidden path="id" id="id"/>

    <label for="isbn">isbn:</label>
    <form:input path="isbn" id="isbn" required="true"/><br><br>

    <label for="title">title:</label>
    <form:input path="title" id="title" required="true"/><br><br>

    <label for="author">author:</label>
    <form:input path="author" id="author" required="true"/><br><br>

    <label for="publisher">publisher:</label>
    <form:input path="publisher" id="publisher" required="true"/><br><br>

    <label for="type">type:</label>
    <form:input path="type" id="type" required="true"/><br><br>

    <button type="submit">Submit</button>
</form:form>
</body>
</html>
