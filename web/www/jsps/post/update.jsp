<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<h3 class="text-center">Update Post</h3>
<sf:form method="post" action="${pageContext.request.contextPath}/post/update/${post.id}" commandName="post">

    <label for="subject">Subject: </label>
    <sf:input class="form-control" id="subject" path="subject"/>


    <label for="posttype">Type: </label>
    <sf:select class="form-control" id="posttype" path="posttype">
        <sf:options items="${typeList}"/>
    </sf:select>


    <label for="content">Content: </label>
    <sf:textarea class="form-control" path="content" id="content" />


    <label for="email">Email: </label>
    <sf:input path="email" class="form-control" id="email"/>
    <br>

    <input class="btn btn-primary form-control" type="submit" value="Update"/>
</sf:form>
