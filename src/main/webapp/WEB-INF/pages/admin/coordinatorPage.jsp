<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:include page="../templates/header_link.jsp"/>
<div class="container">
    <ol class="breadcrumb">
        <li><a href="/admin">Admin Home</a></li>
        <li><a href="/admin/company">Company</a></li>
        <li class="active">Coordinators</li>
        <li><a href="/admin/projects">Project</a></li>
        <li><a href="/admin/allCandidates">Candidates</a></li>
        <p class="navbar-right"><a href="/logout">Log out </a></p>

    </ol>

    <h2>Registration coordinators</h2>

    <div id="registrationCoordinators">
        <form action="/admin/coordinators/createCoordinator" method="post">
            <input id="coordinatorFirstName" type="text" name="firstName" placeholder="firstName">
            <input id="coordinatorLastName" type="text" name="lastName" placeholder="lastName">
            <input id="coordinatorEmail" type="text" name="email" placeholder="email">
            <input id="coordinatorTelephone" type="text" name="telephone" placeholder="telephone">
            <input id="coordinatorUsername" type="text" name="username" placeholder="username">
            <input id="coordinatorPassword" type="password" name="password" placeholder="password">

            <br/>
            <br/>
            <input type="submit" value="REGISTRATION">

            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>

        </form>
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
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${coordinators}" var="coordinator">
            <tr>
                <td>${coordinator.firstName}</td>
                <td>${coordinator.lastName}</td>
                <td>${coordinator.email}</td>
                <td>${coordinator.telephone}</td>
                <td>
                    <a href="/admin/coordinators/remove-${coordinator.id}" ><%--Remove--%><span
                            class="glyphicon glyphicon-remove">Remove </span></a>
                </td>


            </tr>

        </c:forEach>

        </tbody>
    </table>

    <script type="text/javascript" charset="utf-8">
        $('#coordinators').dataTable();
    </script>


</div>
<jsp:include page="../templates/footer.jsp"/>