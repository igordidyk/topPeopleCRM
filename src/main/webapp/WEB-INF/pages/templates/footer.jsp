<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<br>
<br>
<div class="navbar-fixed-bottom">

    <div class="container">
    <footer style="padding-top: 20px">
        <br>
        <br>
        | OKTENWEB DIGITAL STUDIO 2017
        <sec:authorize access="isAuthenticated()">
            | Authorize user : <sec:authentication property="name"></sec:authentication> <a href="/logout">Log out</a>
        </sec:authorize>
    </footer>
</div>

</div>

</body>
</html>