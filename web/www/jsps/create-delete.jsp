<%--
  Created by IntelliJ IDEA.
  User: Cayden
  Date: 16/6/18
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<sf:form method="post" action="${pageContext.request.contextPath}/createsuccess" commandName="offer">
    Name: <sf:input path="name"></sf:input> &nbsp;&nbsp; <sf:errors path="name" cssStyle="color: #ff512e;"></sf:errors> <br>
    Mail: <sf:input path="email"></sf:input> <br>
    Text: <sf:textarea path="text" ></sf:textarea> <br>

    <input type="submit" value="Create"/>
</sf:form>
</body>
</html>
