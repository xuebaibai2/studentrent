<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="container">

    <p><a href="/create">Login Test</a></p>

    <sec:authorize access="hasRole('admin')">
        <p><a href="/admin/adminhome">Admin</a></p>
    </sec:authorize>

</div>

