<%--
  Created by IntelliJ IDEA.
  User: Cayden
  Date: 16/6/19
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<script type="text/javascript">
    $(function () {
        document.f.username.focus();
    })
</script>
<div class="container">
    <h3 class="text-center">User Login</h3>

    <c:if test="${param.error != null}">
        <span class="text-danger">Login failed, username or password is not correct</span>
    </c:if>

    <%--<c:url value="/login" var="loginUrl"/>--%>

    <form name='f' action="${pageContext.request.contextPath}/login" method='POST'>


        <label for="username">User:</label>
        <input id="username" class="form-control" type='text' name='username' value=''>

        <label for="password">Password:</label>
        <input id="password" class="form-control" type='password' name='password'/>

        <label for="rememberme">Remember Me:</label>
        <input id="rememberme" class="checkbox" type='checkbox' name='remember-me'/>
        <br>
        <input class="form-control btn btn-primary" name="submit" type="submit" value="Login"/>
    </form>
    <p><a class="btn btn-success" href="${pageContext.request.contextPath}/account/createaccount">Create new account</a></p>
</div>

