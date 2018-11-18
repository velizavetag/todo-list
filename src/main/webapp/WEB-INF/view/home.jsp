<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="academy.learnprogramming.util.Mappings" %>

<html>
<head>
    <title>TodoList application</title>
</head>

<body>
    <div align="center">
        <c:url var="itemslist" value="${Mappings.ITEMS}"/>
        <h2>  <a href="${itemslist}">Show ToDo items</a></h2>
    </div>
</body>

</html>