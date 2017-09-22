<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="fragments/header_link.jsp"/>

<c:url var="loginUrl" value="/login"/>
<form action="${loginUrl}" method="post" class="login">
    <c:if test="${param.error != null}">
        <p>Invalid username and password.</p>
    </c:if>
    <c:if test="${param.logout != null}">
        <p>You have been logged out successfully.</p>
    </c:if>

    <input type="text" name="username" placeholder="username">
    <br/>
    <input type="password" name="password" placeholder="password">
    <input type="submit" value="go!">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>

<jsp:include page="fragments/footer.jsp"/>