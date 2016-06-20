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
</head>
<body onload='document.f.username.focus();'>
<div class="container">
    <h3>Login with Username and Password</h3>

    <c:if test="${param.error != null}">
        <span class="text-danger">Login failed, username or password is not correct</span>
    </c:if>

    <form name='f' action='/login' method='POST'>


        <label for="username">User:</label>
        <input id="username" class="form-control" type='text' name='username' value=''>

        <label for="password">Password:</label>
        <input id="password" class="form-control" type='password' name='password'/>
        <br>
        <input class="form-control btn btn-primary" name="submit" type="submit" value="Login"/>
    </form>
</div>
</body>
</html>