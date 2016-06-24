<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <title><tiles:insertAttribute name="title"></tiles:insertAttribute></title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<div class="header">
    <tiles:insertAttribute name="header"></tiles:insertAttribute>
</div>
<div class="container">
    <tiles:insertAttribute name="content"></tiles:insertAttribute>
</div>
<div class="footer">
    <tiles:insertAttribute name="footer"></tiles:insertAttribute>
</div>
</body>
</html>
