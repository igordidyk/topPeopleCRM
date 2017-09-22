<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>


<br>
<sec:authorize access="isAuthenticated()">
    <br/>
    | Authorize user : <sec:authentication property="name"></sec:authentication>
    <br/>
    | User roles : <sec:authentication property="principal.authorities"></sec:authentication>
    <br/>
    <c:url var="logoutUrl" value="/logout"/>
    <a href="${logoutUrl}" >logout</a>
</sec:authorize>
<script src="/js/main.js"></script>
</body>
</html>