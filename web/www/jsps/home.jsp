<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Home View</title>
    <link href="/static/css/main.css" rel="stylesheet" type="text/css">
    <link href="/static/css/bootstrap.css" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<div id="container">

    <p><a href="/create">Login Test</a></p>
    <sec:authorize access="!isAuthenticated()">
        <p><a href="/login">Login</a></p>
    </sec:authorize>

    <sec:authorize access="isAuthenticated()">
        <c:url var="logoutUrl" value="/logout"/>
        <form action="${logoutUrl}" method="post">
            <input type="submit" value="Log out"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        </form>
    </sec:authorize>
    <sec:authorize access="hasRole('admin')">
        <p><a href="/admin/adminhome">Admin</a></p>
    </sec:authorize>

</div>
</body>
</html>
