<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:include page="templates/header_link.jsp"/>

<div class="container">
    <ol class="breadcrumb">
        <li class="active">Admin Home</li>
        <li><a href="/admin/company">Company</a></li>
        <li><a href="/admin/coordinators">Coordinators</a></li>
        <li><a href="/admin/projects">Project</a></li>
        <li><a href="/admin/allEmployee">Employee</a></li>
        <p class="navbar-right"><a href="/logout" >Log out  </a></p>
    </ol>
    <br/>
    <h2>security check</h2>
    ${principal}
    <br>
    <br>
    <h3>Congratulations to Admin page </h3>

</div>
<jsp:include page="templates/footer.jsp"/>

