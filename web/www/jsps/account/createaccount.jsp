<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script type="application/javascript" src="/static/js/js.js"></script>
<div class="container">
    <h3 class="text-center">Register new account</h3>
    <sf:form id="create_form" method="post" action="/account/createaccount" commandName="account">
        <label for="username">Username: </label>
        <sf:input id="username" class="form-control" path="username"/>
        <div class="alert alert-danger alert-dismissable fade in">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <p><sf:errors path="username" cssClass="text-danger"/></p>
        </div>


        <label for="email">Email: </label>
        <sf:input id="email" class="form-control" path="email"/>
        <div class="alert alert-danger alert-dismissable fade in">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <p><sf:errors path="Email" cssClass="text-danger"/></p>
        </div>


        <label for="password">Password: </label>
        <sf:password id="password" class="form-control" path="password"/>
        <div class="alert alert-danger alert-dismissable fade in">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <p><sf:errors path="password" cssClass="text-danger"/></p>
        </div>


        <label for="c_password">Confirm Password: </label>
        <input id="c_password" class="form-control password-field" name="c_password" type="password"/>
        <div class="c_p_m alert alert-danger alert-dismissable fade in">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <p id="c_password_msg"></p>
        </div>
        <br>

        <input class="form-control btn btn-primary" type="submit" value="Register"/>

    </sf:form>
</div>
