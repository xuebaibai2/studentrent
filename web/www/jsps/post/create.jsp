<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <h2 class="text-center">Create a new rent post</h2>
    <sf:form method="post" action="/post/create" commandName="post">

        <%--Subject--%>
        <label for="subject">Subject: </label>
        <sf:input id="subject" class="form-control" path="subject"/>
        <div class="alert alert-danger alert-dismissable fade in">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <p><sf:errors path="subject" cssClass="text-danger"/></p>
        </div>

        <%--Content--%>
        <label for="content">Content: </label>
        <sf:textarea id="content" class="form-control" path="content"/>
        <div class="alert alert-danger alert-dismissable fade in">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <p><sf:errors path="content" cssClass="text-danger"/></p>
        </div>

        <%--Email--%>
        <label for="email">Email: </label>
        <sf:input id="email" class="form-control" path="email"/>
        <div class="alert alert-danger alert-dismissable fade in">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <p><sf:errors path="Email" cssClass="text-danger"/></p>
        </div>

        <input class="form-control btn btn-primary" type="submit" value="Post"/>
    </sf:form>
</div>

