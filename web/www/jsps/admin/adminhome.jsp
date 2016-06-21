<%--
  Created by IntelliJ IDEA.
  User: Cayden
  Date: 16/6/21
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Admin Home</title>
    <link href="/static/css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body>
<h3 class="text-center">Authorised Users Only</h3>

<div class="container">
    <table class="table table-striped">
        <tr><td>Username</td><td>Email</td><td>Role</td><td>Enabled</td></tr>

        <c:forEach var="account" items="${accounts}">
            <tr>
                <td><c:out value="${account.username}"></c:out></td>
                <td><c:out value="${account.email}"></c:out></td>
                <td><c:out value="${account.authority}"></c:out></td>
                <td><c:out value="${account.enabled}"></c:out></td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
