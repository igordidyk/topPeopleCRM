<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:include page="templates/header_link.jsp"/>

<div class="container">
    <ol class="breadcrumb">
        <li class="active"><%--<a href="/admin">Admin Home</a>--%>Coordinator Home</li>
        <li><a href="/coordinator/candidates">Employee</a></li>
        <li><a href="/coordinator/myAccount">Account details</a></li>
        <p class="navbar-right"><a href="/logout" >Log out  </a></p>
    </ol>

    <p>Hello,
        ${coordinatorName},
        welcome to your private cabinet
    <p>You currently have access to a block of your personal data and employees</p>
</div>

<jsp:include page="templates/footer.jsp"/>



