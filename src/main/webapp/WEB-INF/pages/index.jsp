<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:include page="templates/header_link.jsp"/>
<div class="container">
    Welcome to the company<br>
    <h2>TopPeople</h2>
    <%--<a href="status">proceeding status</a>--%>
    <%----%>

    <sec:authorize access="hasRole('ADMIN')">
        <a href="/admin">Go Admin account</a>
    </sec:authorize>
    <br/>
    <sec:authorize access="hasRole('USER')">
        <p>You are the coordinator of the company</p>
        <a href="/coordinator">Go to your personal account</a>
    </sec:authorize>
</div>
<jsp:include page="templates/footer.jsp"/>
