<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:include page="../templates/header_link.jsp"/>

<div class="container">
    <ol class="breadcrumb">
        <li><a href="/admin/company">Company</a></li>
        <li class="active">Contact Person</li>
        <p class="navbar-right"><a href="/logout" >Log out  </a></p>
    </ol>
    <br/>
    <h2>Add contact persons to company : <strong>${company.nameCompany}</strong></h2>
    <c:url var="addPerson" value="/admin/company/addContactPerson"/>
    <form action="${addPerson}" method="post">
        <input type="text" name="firstName" placeholder="firstName">
        <input type="text" name="lastName" placeholder="lastName">
        <input type="text" name="position" placeholder="position">
        <input type="text" name="email" placeholder="email">
        <input type="text" name="telephone" placeholder="telephone">
        <input type="hidden" name="idCompany" value="${company.id}">
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
        <br/>
        ${key}
        <br/>
        <input type="submit"  value="add contact Person">
    </form>

    <br/>
    <br/>
    <br/>
    <br/>


    <table id="contactPerson">
        <thead>
        <tr>
            <th>Name</th>
            <th>Last Name</th>
            <th>Position</th>
            <th>Email</th>
            <th>Telephone</th>
            <th>Options</th>


        </tr>
        </thead>

        <tbody>
        <c:forEach items="${company.persons}" var="person">
            <tr>
                <td>${person.firstName}</td>
                <td>${person.lastName}</td>
                <td>${person.position}</td>
                <td>${person.email}</td>
                <td>${person.telephone}</td>
                <td>
                    <a href="/admin/company/delete-${person.id}">delete Person</a>
                    <a href="/admin/company/editPerson-${person.id}" >edit Person</a>
                </td>

            </tr>

        </c:forEach>
        </tbody>
    </table>
    <script type="text/javascript" charset="utf-8">
        $('#contactPerson').dataTable();
    </script>

</div>


<jsp:include page="../templates/footer.jsp"/>
