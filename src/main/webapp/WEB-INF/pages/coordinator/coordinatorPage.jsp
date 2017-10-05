<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


    <h2> All registered coordinators</h2>
    <table id="coordinators">
        <thead>
        <tr>
            <th>firstName</th>
            <th>lastName</th>
            <th>email</th>
            <th>telephone</th>
            <th>Options</th>
            <%--<th>username</th>--%>
            <%--<th>password</th>--%>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${coordinators}" var="coordinator">
            <tr>
                <td>${coordinator.firstName}</td>
                <td>${coordinator.lastName}</td>
                <td>${coordinator.email}</td>
                <td>${coordinator.telephone}</td>
                    <%--<td><a href="/admin/coordinators/remove-${coordinator.id}">delete Coordinator</a></td>--%>
                    <%--<a href="#"><span class="glyphicon glyphicon-envelope"></span></a>--%>
                <td>
                    <a id="removeCoordinator-${coordinator.id}"><span
                            class="glyphicon glyphicon-remove"></span></a>
                </td>


            </tr>

        </c:forEach>

        </tbody>
    </table>

    <script type="text/javascript" charset="utf-8">
        $('#coordinators').dataTable();
    </script>


    <script src="/js/coordinatorScript.js"></script>
</div>
<jsp:include page="../templates/footer.jsp"/>