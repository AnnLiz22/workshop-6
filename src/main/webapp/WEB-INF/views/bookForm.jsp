<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<html>
<head>
    <title>Book form</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<div class="container py-4 px-3 mx-auto">

<nav class="navbar navbar-expand-lg navbar-dark border-top bg-light">
    <div class="px-4 py-3"> <a href="${pageContext.request.contextPath}/">Home</a> </div>
    <div class="px-4 py-3"> <a href="${pageContext.request.contextPath}/admin/books/form">Add new book</a></div>
    <div class="px-4 py-3">  <a href="${pageContext.request.contextPath}/admin/books/all">Book list</a></div>
</nav>

    <header class="px-4 py-3 d-flex justify-content-between align-items-md-center pb-3 mb-5 border-bottom border-top bg-light">

<h3>Book form</h3>
    </header>
    <div class="px-4 py-3 bg-light rounded-2">

    <form:form action="/admin/books/form/add" method="post"  modelAttribute="book" >
    <form:hidden path="id" id="id"/>

    <label for="isbn">Isbn number: </label>
    <form:input path="isbn" id="isbn" required="true"/><br><br>

    <label for="title">Title: </label>
    <form:input path="title" id="title" required="true"/><br><br>

    <label for="author">Author: </label>
    <form:input path="author" id="author" required="true"/><br><br>

    <label for="publisher">Publisher: </label>
    <form:input path="publisher" id="publisher" required="true"/><br><br>

    <label for="type">Type: </label>
    <form:select path="type.id" id="type" required=" true"><br><br>
        <form:options items="${types}" />
    </form:select>

    <button type="submit">Submit</button>
</form:form>
    </div>
</div>
</body>
</html>
