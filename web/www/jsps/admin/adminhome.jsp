
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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

