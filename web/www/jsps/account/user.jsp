<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<style type="text/css">
    .sub-navbar-nav > li > a {background-color:darkgray !important;color:white !important; margin-left: 2px;}
    .sub-navbar-nav > li > a {padding-top:5px !important; padding-bottom:5px !important; }
    .sub-navbar {min-height:32px !important}
</style>
<div class="navbar navbar-default sub-navbar">
    <div class="container-fluid">
        <ul class="nav navbar-nav navbar-right sub-navbar-nav">
            <sec:authorize access="hasRole('ROLE_admin')">
                <li>
                <a class="nav navbar-nav" href="${pageContext.request.contextPath}/account/update/${user.username}">
                    Update Profile
                </a>
                </li>
            </sec:authorize>

            <sec:authorize access="hasRole('ROLE_user')">
                <li>
                <c:if test="${isAuthor}">
                    <a class="nav navbar-nav" href="${pageContext.request.contextPath}/account/update/${user.username}">
                        Update Profile
                    </a>
                    <a class="nav navbar-nav" href="${pageContext.request.contextPath}/account/updatepassword/${user.username}">
                        Update Password
                    </a>
                </c:if>
                </li>
            </sec:authorize>
        </ul>
    </div>
</div>

<h3 class="text-center">
    <c:out value="${user.username}'s Profile"/>
</h3>
<br>

<div>
    <table class="table table-striped">
        <tr class="text-muted small">
            <td>Name</td>
            <td>Phone Number</td>
            <td>Email</td>
            <td>Gender</td>
        </tr>
        <tr>
            <td>
                <c:out value="${user.firstName}"></c:out>&nbsp;
                <c:out value="${user.lastName}"></c:out>
            </td>
            <td><c:out value="${user.phonenumber}"></c:out></td>
            <td><c:out value="${user.email}"></c:out></td>
            <td><c:out value="${user.gender}"></c:out></td>
        </tr>
    </table>

</div>
