<%--
  Created by IntelliJ IDEA.
  User: Cayden
  Date: 16/6/19
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Login Page</title>
    <link href="/static/css/bootstrap.css" rel="stylesheet" type="text/css">
    <!-- default header name is X-CSRF-TOKEN -->
    <%--<meta name="_csrf_header" content="${_csrf.headerName}"/>--%>

</head>
<body onload='document.f.username.focus();'>
<div class="container">
    <h3 class="text-center">User Login</h3>

    <c:if test="${param.error != null}">
        <span class="text-danger">Login failed, username or password is not correct</span>
    </c:if>

    <c:url value="/login" var="loginUrl"/>

    <%--<form name='f' action='/login' method='POST'>--%>
    <form name='f' action=${loginUrl} method='POST'>


        <label for="username">User:</label>
        <input id="username" class="form-control" type='text' name='username' value=''>

        <label for="password">Password:</label>
        <input id="password" class="form-control" type='password' name='password'/>

        <label for="rememberme">Remember Me:</label>
        <input id="rememberme" class="checkbox" type='checkbox' name='remember-me'/>
        <br>
        <input class="form-control btn btn-primary" name="submit" type="submit" value="Login"/>
    </form>
    <p><a class="btn btn-success" href="/account/createaccount">Create new account</a></p>
</div>

</body>
</html>