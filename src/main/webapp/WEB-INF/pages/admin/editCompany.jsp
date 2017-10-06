<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<jsp:include page="../templates/header_link.jsp"/>
<div class="container">
    <ol class="breadcrumb">
        <li><a href="/admin/company">Company</a></li>
        <li class="active">Edit company</li>
        <p class="navbar-right"><a href="/logout">Log out </a></p>

    </ol>

    <h2>Edit company information</h2>
    <form action="/admin/company/save" method="post">
        <input type="text" name="nameCompany" value="${company.nameCompany}" placeholder="nameCompany">
        <input type="text" name="IC" placeholder="IC" value="${company.IC}">
        <input type="text" name="contactAddress" placeholder="Contact Address" value="${company.contactAddress}">
        <input type="text" name="telephone" placeholder="telephone" value="${company.telephone}">
        <input type="text" name="email" placeholder="email" value="${company.email}">
        <input type="text" name="CZ_NACE" placeholder="CZ_NACE" value="${company.CZ_NACE}">
        <input type="hidden" name="company" value="${company.id}">
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
        <br>
        <br>
        <input type="submit" value="save Changes">

    </form>

</div>

<jsp:include page="../templates/footer.jsp"/>
