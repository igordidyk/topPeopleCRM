<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="container">
<div class="navbar-fixed-bottom">

        <footer style="padding-top: 60px">
            <br/>
            <sec:authorize access="isAuthenticated()">
                | Authorize user : <sec:authentication property="name"></sec:authentication> <a href="/logout">Log out</a>
            </sec:authorize>
            <p>Ⓒ OKTENWEB DIGITAL STUDIO 2017</p>
        </footer>
    </div>
</div>

</body>
</html>