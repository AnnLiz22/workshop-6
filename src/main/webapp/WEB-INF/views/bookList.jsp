
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <title>Book List</title>
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
    <a href="${pageContext.request.contextPath}/admin/books/form">Add new book</a><br><br>
    <a href="${pageContext.request.contextPath}/admin/books/all">Book list</a><br><br>

</nav>
<table>
    <thead>
    <th>id</th>
    <th>isbn</th>
    <th>title</th>
    <th>author</th>
    <th>publisher</th>
    <th>type</th>
    <th>edit book</th>
    <th>delete book</th>
    </thead>
    <tbody>

    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.isbn}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.publisher}</td>
            <td>${book.type}</td>


            <td>
                <form:form action="/admin/books/edit/${book.id}" method="post" cssStyle="display:inline;">
                    <input type="submit" value="Edit"/>
                </form:form>
            </td>
            <td>
                <form:form action="/admin/books/delete/${book.id}" method="post" cssStyle="display:inline;"
                           onClick="return confirm('Are you sure you want to delete book?')">
                    <input type="submit" value="Delete"/>
                </form:form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
