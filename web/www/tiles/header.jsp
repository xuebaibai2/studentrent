<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Student House Rent</a>
        </div>

        <ul class="nav navbar-nav">
            <li class="active"><a href="/home">Home</a></li>
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span
                    class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="#">Page 1-1</a></li>
                    <li><a href="#">Page 1-2</a></li>
                    <li><a href="#">Page 1-3</a></li>
                </ul>
            </li>
            <li><a href="/create">Login Test</a></li>

            <sec:authorize access="hasRole('admin')">
                <li>
                    <a href="/admin/adminhome">Admin</a>
                </li>
            </sec:authorize>

        </ul>

        <ul class="nav navbar-nav navbar-right">
            <sec:authorize access="!isAuthenticated()">
                <li>
                    <a href="/account/createaccount"><span class="glyphicon glyphicon-user"></span> Sign Up</a>
                </li>
            </sec:authorize>
            <sec:authorize access="!isAuthenticated()">
                <li>
                    <a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a>
                </li>
            </sec:authorize>


            <sec:authorize access="isAuthenticated()">
                <li>
                    <a href="javascript:document.forms['logout'].submit()">
                        <span class="glyphicon glyphicon-log-out"></span> Log out</a>
                </li>
            </sec:authorize>

        </ul>
        <form name="logout" action="/logout" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        </form>
    </div>
</nav>