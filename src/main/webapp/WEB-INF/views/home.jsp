
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book Api</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="styles/styles.css">

</head>
<body>
<div class="container py-4 px-3 mx-auto">

    <nav class="navbar navbar-expand-lg navbar-dark borer-top bg-light rounded-2">
        <div class="px-4 py-3"> <a href="${pageContext.request.contextPath}">Home</a> </div>
        <div class="px-4 py-3"> <a href="${pageContext.request.contextPath}/admin/books/form">Add new book</a></div>
        <div class="px-4 py-3">  <a href="${pageContext.request.contextPath}/admin/books/all">Book list</a></div>

    </nav>


    <header class="px-4 py-3 d-flex justify-content-between align-items-md-center pb-3 mb-5 border-bottom border-top bg-light">
<h3>Welcome page</h3>

    </header>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
