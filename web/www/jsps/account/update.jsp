<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="hasRole('ROLE_admin')">
    <h3 class="text-center">Update Profile for ${user.username}</h3>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_user')">
    <h3 class="text-center">Update Profile </h3>
</sec:authorize>


<sf:form method="post" action="${pageContext.request.contextPath}/account/update/${user.username}" commandName="user">

    <label for="f_name">First Name: </label>
    <sf:input class="form-control" id="f_name" path="firstName"/>

    <label for="l_name">Last Name: </label>
    <sf:input class="form-control" id="l_name" path="lastName"/>

    <label for="gender">Type: </label>
    <sf:select class="form-control" id="gender" path="gender">
        <sf:options items="${gender}"/>
    </sf:select>

    <label for="email">Email: </label>
    <sf:input class="form-control" id="email" path="Email"/>

    <label for="phone">Phone: </label>
    <sf:input class="form-control" id="phone" path="phonenumber"/>
    <sf:hidden class="form-control" path="id"/>
    <br>

    <input class="btn btn-primary form-control" type="submit" value="Update"/>
</sf:form>
