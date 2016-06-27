<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<c:if test="${isAuthor}">
    <a class="btn btn-sm btn-default" href="${pageContext.request.contextPath}/post/update/${post.id}">Edit Post</a>
</c:if>
<table class="table table-view">
    <tr>
        <td>Subject:</td>
        <td><c:out value="${post.subject}"></c:out></td>
    </tr>

    <tr>
        <td>Email:</td>
        <td><c:out value="${post.email}"></c:out></td>
    </tr>

    <tr>
        <td>Renttype:</td>
        <td><c:out value="${post.posttype}"></c:out></td>
    </tr>
    <tr>
        <td>User:</td>
        <td>
            <a href="${pageContext.request.contextPath}/account/user/${post.user.username}">
                <c:out value="${post.user.username}"></c:out>
            </a>
        </td>
    </tr>
    <tr>
        <td>Posted:</td>
        <td><c:out value="${post.postdate_display}"></c:out></td>
    </tr>
    <tr>
        <td>Content:</td>
        <td>${fn:replace(fn:escapeXml(post.content), newLineChar, "<br>")}</td>
    </tr>

</table>
