<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:include page="../templates/header_link.jsp"/>

<div class="container">

    <ol class="breadcrumb">
        <li><a href="/admin">Admin Home</a></li>
        <li class="active">Company</li>
        <li><a href="/admin/coordinators">Coordinators</a></li>
        <li><a href="/admin/projects">Project</a></li>
        <li><a href="/admin/allEmployee">Employee</a></li>
        <p class="navbar-right"><a href="/logout">Log out </a></p>

    </ol>


    <h2>Add Company </h2>
    <form action="/admin/addCompany" method="post">
        <input type="text" name="nameCompany" placeholder="Name Company">
        <input type="text" name="IC" placeholder="IC">
        <input type="text" name="contactAddress" placeholder="Contact Address">
        <input type="text" name="telephone" placeholder="telephone">
        <input type="text" name="email" placeholder="email">
        <input type="text" name="CZ_NACE" placeholder="CZ_NACE">
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
        <br/>
        <br/>
        <input type="submit" value="CREATE">

    </form>
    <br/>
    <br/>
    <h2>All added companies</h2>
    <table id="company">
        <thead>
        <tr>
            <th class="disable-sorting">#</th>
            <th>Company</th>
            <th>Telephone</th>
            <th>Email</th>
            <th>IC</th>
            <th>Contact Address</th>

            <th>Options</th>

        </tr>
        </thead>

        <tbody>
        <c:forEach items="${companies}" var="company">
            <tr>

                <td>${company.id}</td>
                <td>${company.nameCompany}</td>
                <td>${company.telephone}</td>
                <td>${company.email}</td>
                <td>${company.IC}</td>
                <td>${company.contactAddress}</td>
                <td>
                    <div style="list-style-type: none; text-decoration: none">
                        <li><a href="/admin/company/edit-${company.id}" > edit Company </a></li>
                        <li><a href="/admin/company/contactPersonWithCompany-${company.id}" > Contact Person </a></li>
                        <li><a href="/admin/company/czisco-${company.id}" > CZISCO </a></li>
                    </div>

                </td>

            </tr>


        </c:forEach>
        </tbody>
    </table>
    <script type="text/javascript" charset="utf-8">
        $('#company').dataTable();
    </script>

</div>


<jsp:include page="../templates/footer.jsp"/>
