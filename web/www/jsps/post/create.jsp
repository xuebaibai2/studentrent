<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Cayden
  Date: 16/6/21
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new Rent Post</title>
    <link href="/static/css/bootstrap.css" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script type="application/javascript" src="/static/js/js.js"></script>
</head>
<body>
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
</body>
</html>
