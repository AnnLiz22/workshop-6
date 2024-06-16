
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <title>Book List</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<div class="container py-4 px-3 mx-auto">
<nav class="navbar navbar-expand-lg navbar-dark borer-top bg-light rounded-2">
  <div class="px-4 py-3"> <a href="${pageContext.request.contextPath}/">Home</a> </div>
    <div class="px-4 py-3"> <a href="${pageContext.request.contextPath}/admin/books/form">Add new book</a></div>
    <div class="px-4 py-3">  <a href="${pageContext.request.contextPath}/admin/books/all">Book list</a></div>

</nav>

    <header class="px-4 py-3 d-flex justify-content-between align-items-md-center pb-3 mb-5 border-bottom border-top bg-light">
        <h3>Book list</h3>
    </header>

    <div class="px-4 py-3 bg-light rounded-2">

    <table>
        <thead class="border-bottom">

        <th class="px-4 py-3">Id</th>
        <th class="px-4 py-3">Isbn number</th>
    <th class="px-4 py-3">Title</th>
    <th class="px-4 py-3">Author</th>
    <th class="px-4 py-3">Publisher</th>
    <th class="px-4 py-3">Type</th>
    <th class="px-4 py-3">Edit book</th>
    <th class="px-4 py-3">Delete book</th>
    <th class="px-4 py-3">Show details</th>
    </thead>
    <tbody>

    <c:forEach items="${books}" var="book">
        <tr>
           <td class="px-4 py-3">${book.id}</td>
            <td class="px-4 py-3">${book.isbn}</td>
            <td class="px-4 py-3">${book.title}</td>
            <td class="px-4 py-3">${book.author}</td>
            <td class="px-4 py-3">${book.publisher}</td>
            <td class="px-4 py-3">${book.type}</td>


            <td class="px-4 py-3">
                <form:form action="/admin/books/edit/${book.id}" method="post" cssStyle="display:inline;">
                    <input type="submit" value="Edit"/>
                </form:form>
            </td>
            <td class="px-4 py-3">
                <form:form action="/admin/books/delete/${book.id}" method="post" cssStyle="display:inline;"
                           onClick="return confirm('Are you sure you want to delete this book?')">
                    <input type="submit" value="Delete"/>
                </form:form>
            </td>
            <td class="px-4 py-3">
                <form:form action="/admin/books/book/${book.id}" method="get" cssStyle="display:inline;">
                    <input type="submit" value="Show">
                </form:form>

            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
    </div>
</div>
</body>
</html>
