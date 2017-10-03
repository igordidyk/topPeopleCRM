<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:include page="../templates/header_link.jsp"/>


<ul class="breadcrumb">
    <li><a href="/admin">Admin</a></li>
    <li><a href="/admin/company" >Company</a></li>
    <li><a href="/admin/coordinator">Coordinator</a></li>
</ul>
<br/>
<form action="/admin/coordinators/createCoordinator" method="post">
    <input type="text" name="firstName" placeholder="firstName">
    <input type="text" name="lastName" placeholder="lastName">
    <input type="text" name="email" placeholder="email">
    <input type="text" name="telephone" placeholder="telephone">
    <input type="text" name="username" placeholder="username">
    <input type="password" name="password" placeholder="password">
    <input type="submit" value="registration">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>

</form>


<jsp:include page="../templates/footer.jsp"/>
