<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav id="na_bar" class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/home">Student House Rent</a>
        </div>

        <ul class="nav navbar-nav">

            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">
                <span class="glyphicon glyphicon-list"></span> View Post<span
                    class="caret"></span></a>
                <ul class="dropdown-menu">
                    <sec:authorize access="isAuthenticated()">
                        <li class="list-cell"><a href="/post/mypost">My Posts</a></li>
                    </sec:authorize>
                    <li><a href="/post/post">All Posts</a></li>
                </ul>
            </li>
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
                    <a href="/post/create">
                        <span class="glyphicon glyphicon-pencil"></span> New Post</a>
                </li>

                <sec:authorize access="hasRole('admin')">
                    <li>
                        <a href="/admin/adminhome">
                            <span class="glyphicon glyphicon-user"></span> Admin</a>
                    </li>
                </sec:authorize>

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