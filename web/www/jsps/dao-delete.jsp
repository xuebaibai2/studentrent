<%--
  Created by IntelliJ IDEA.
  User: Cayden
  Date: 16/6/18
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="offer" items="${offers}">
    ID: ${offer.id}<br>
    Email: ${offer.email}<br>
    Name: ${offer.name}<br>
    Text: ${offer.text}<br>
</c:forEach>
</body>
</html>
