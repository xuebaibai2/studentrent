<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home View</title>
    <link href="/static/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="container">
    How are you, finally here at controller how are you <br>

    Request: <%=request.getAttribute("name")%><br>

    Request: (using Expression Language) ${name}<br>

    Request: (using JSTL prefix) <c:out value="${name}"></c:out> <br>
</div>
</body>
</html>
