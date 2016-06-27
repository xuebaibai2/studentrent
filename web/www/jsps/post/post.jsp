<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table class="table table-striped">
    <tr>
        <td>Subject</td>
        <td>Type</td>
        <td>PostDate</td>
        <td>User</td>
    </tr>

    <c:forEach var="post" items="${postList}">
        <tr>
            <td>
                <a href="${pageContext.request.contextPath}/post/post/${post.id}">
                    <c:out value="${post.subject}"/>
                </a>
            </td>
            <td><c:out value="${post.posttype}"></c:out></td>
            <td><c:out value="${post.postdate_display}"></c:out></td>
            <td>
                <a href="${pageContext.request.contextPath}/account/user/${post.user.username}">
                    <c:out value="${post.user.username}"></c:out>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
