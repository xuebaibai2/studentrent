<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3 class="text-center">My Posts</h3>
<table class="table table-striped">
    <tr><td>Subject</td><td>Type</td><td>PostDate</td></tr>

    <c:forEach var="post" items="${postList}">
        <tr>
            <td><a href="${pageContext.request.contextPath}/post/post/${post.id}"><c:out value="${post.subject}"></c:out></a></td>
            <td><c:out value="${post.posttype}"></c:out></td>
            <td><c:out value="${post.postdate_display}"></c:out></td>
        </tr>
    </c:forEach>
</table>