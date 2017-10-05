<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:include page="../templates/header_link.jsp"/>
<div class="container">
    <ol class="breadcrumb">
        <li><a href="/admin">Admin Home</a></li>
        <li><a href="/admin/company">Company</a></li>
        <li class="active"><%--<a href="/admin/coordinators" >Coordinators</a>--%>Coordinators</li>
        <li><a href="/admin/project">Project</a></li>
        <li><a href="/admin/allEmployee">Employee</a></li>
        <p class="navbar-right"><a href="/logout">Log out </a></p>

    </ol>

    <h2>Registration coordinators</h2>
    <div id="registrationCoordinators">
        <input id="coordinatorFirstName" type="text" name="firstName" placeholder="firstName">
        <input id="coordinatorLastName" type="text" name="lastName" placeholder="lastName">
        <input id="coordinatorEmail" type="text" name="email" placeholder="email">
        <input id="coordinatorTelephone" type="text" name="telephone" placeholder="telephone">
        <input id="coordinatorUsername" type="text" name="username" placeholder="username">
        <input id="coordinatorPassword" type="password" name="password" placeholder="password">

    <br/>
    <br/>
    <button id="saveCoordinator">REGISTRATION</button>
    </div>


    <div class="showCoordinators">

    </div>

    <script src="/js/coordinatorScript.js"></script>
</div>
<jsp:include page="../templates/footer.jsp"/>